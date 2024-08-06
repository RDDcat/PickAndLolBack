package com.pickandlol.pickandlol.Config;

import com.pickandlol.pickandlol.Repository.MemberTokenRepositoryJPA;
import com.pickandlol.pickandlol.Service.OAuthService;
import com.pickandlol.pickandlol.jose.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // spring security 설정을 활성화시켜주는 어노테이션
public class SecurityConfig {

    private final OAuthService oAuthService;
    private final AuthenticationSuccessHandler successHandler;
    private final JwtUtil jwtUtil;
    private final MemberTokenRepositoryJPA memberTokenRepositoryJPA;

    @Autowired
    public SecurityConfig(OAuthService oAuthService, AuthenticationSuccessHandler successHandler, JwtUtil jwtUtil, MemberTokenRepositoryJPA memberTokenRepositoryJPA) {
        this.oAuthService = oAuthService;
        this.successHandler = successHandler;
        this.jwtUtil = jwtUtil;
        this.memberTokenRepositoryJPA = memberTokenRepositoryJPA;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers(HttpMethod.GET, "/health").permitAll()
                            .requestMatchers("/error").permitAll()
                            .requestMatchers("/favicon.ico").permitAll()

                            .requestMatchers(HttpMethod.GET,"/match").permitAll()
                            .requestMatchers(HttpMethod.POST,"/match").permitAll()
                            .requestMatchers(HttpMethod.POST,"/match/**").permitAll()

                            .requestMatchers(HttpMethod.GET, "/club/all").permitAll()

                            .requestMatchers(HttpMethod.GET, "/player/all").permitAll()

                            .requestMatchers("/team/statistic").permitAll()

                            .requestMatchers(HttpMethod.GET, "/rank").permitAll()
                            .requestMatchers(HttpMethod.POST, "/save").permitAll()
                            .requestMatchers(HttpMethod.POST, "/team/log").permitAll()
                            .requestMatchers(HttpMethod.PUT, "/team/change/**").permitAll()


                            .requestMatchers(HttpMethod.GET, "/token/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/refresh").permitAll()
                            .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                    .successHandler(successHandler) // 커스텀 성공 핸들러 사용
                    .userInfoEndpoint(userInfo -> userInfo
                            .userService(oAuthService) // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                    )
            )
            .addFilterBefore(new JwtAuthenticationFilter(jwtUtil, memberTokenRepositoryJPA), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}