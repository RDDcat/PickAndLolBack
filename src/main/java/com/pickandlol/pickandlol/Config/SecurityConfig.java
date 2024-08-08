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
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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
    public WebSecurityCustomizer webSecurityCustomizer() { // security를 적용하지 않을 리소스
        return web -> web.ignoring()
                // error endpoint를 열어줘야 함, favicon.ico 추가!
                .requestMatchers("/error", "/favicon.ico")
                .requestMatchers(HttpMethod.GET, "/health")
                .requestMatchers("/error")
                .requestMatchers("/favicon.ico")

                .requestMatchers(HttpMethod.GET, "/match")
                .requestMatchers(HttpMethod.POST, "/match")
                .requestMatchers(HttpMethod.POST, "/match/**")

                .requestMatchers(HttpMethod.GET, "/club/all")

                .requestMatchers(HttpMethod.GET, "/player/all")
                .requestMatchers(HttpMethod.POST, "/player/log")

                .requestMatchers("/team/statistic")

                .requestMatchers(HttpMethod.GET, "/rank")
                .requestMatchers(HttpMethod.POST, "/team/log")
                .requestMatchers(HttpMethod.PUT, "/team/change/**")


                .requestMatchers(HttpMethod.GET, "/token/**")
                .requestMatchers(HttpMethod.POST, "/refresh");
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(HttpMethod.GET, "/member").permitAll()
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