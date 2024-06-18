package com.pickandlol.pickandlol.Config;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Service.OAuthService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final OAuthService oAuthService;
    private final RestTemplate restTemplate = new RestTemplate();

    public CustomAuthenticationSuccessHandler(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        Member member = oAuthService.getCurrentMember(authentication); // 현재 로그인한 사용자의 Member 객체를 가져옵니다.

        System.out.println("onauth 실행");

        // 필요한 데이터를 리다이렉트 URL에 추가합니다.
        String redirectUrl = "http://pickandlol.tasty-site.com?name=" + member.getName() + "&email=" + member.getEmail();

        response.sendRedirect(redirectUrl); // 리다이렉트 수행
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Member member = oAuthService.getCurrentMember(authentication); // 현재 로그인한 사용자의 Member 객체를 가져옵니다.

        System.out.println("onauth 실행");

        // 필요한 데이터를 리다이렉트 URL에 추가합니다.
        String redirectUrl = "http://pickandlol.tasty-site.com?name=" + member.getName() + "&id=" + member.getOauthId();

        response.sendRedirect(redirectUrl); // 리다이렉트 수행
    }
}
