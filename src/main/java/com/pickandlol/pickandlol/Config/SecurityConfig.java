package com.pickandlol.pickandlol.Config;

import com.pickandlol.pickandlol.Service.OAuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity // spring security 설정을 활성화시켜주는 어노테이션
public class SecurityConfig {

    private final OAuthService oAuthService;
    private final AuthenticationSuccessHandler successHandler;

    public SecurityConfig(OAuthService oAuthService, AuthenticationSuccessHandler successHandler) {
        this.oAuthService = oAuthService;
        this.successHandler = successHandler;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .oauth2Login(oauth2 -> oauth2
                    .successHandler(successHandler) // 커스텀 성공 핸들러 사용
                    .userInfoEndpoint(userInfo -> userInfo
                            .userService(oAuthService) // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                    )
            );

        return http.build();
    }
}