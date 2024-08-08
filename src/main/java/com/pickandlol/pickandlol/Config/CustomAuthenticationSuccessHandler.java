package com.pickandlol.pickandlol.Config;

import com.pickandlol.pickandlol.Model.DAO.Member;
import com.pickandlol.pickandlol.Model.DAO.MemberTokenDAO;
import com.pickandlol.pickandlol.Repository.MemberTokenRepositoryJPA;
import com.pickandlol.pickandlol.Service.OAuthService;
import com.pickandlol.pickandlol.jose.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final OAuthService oAuthService;
    JwtUtil jwtUtil;
    MemberTokenRepositoryJPA memberTokenRepositoryJPA;

    @Autowired
    public CustomAuthenticationSuccessHandler(OAuthService oAuthService, JwtUtil jwtUtil, MemberTokenRepositoryJPA memberTokenRepositoryJPA) {
        this.oAuthService = oAuthService;
        this.jwtUtil = jwtUtil;
        this.memberTokenRepositoryJPA = memberTokenRepositoryJPA;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

        Member member = oAuthService.getCurrentMember(authentication); // 현재 로그인한 사용자의 Member 객체를 가져옵니다.

        String accessToken = jwtUtil.generateAccessToken(member);
        String refreshToken = jwtUtil.generateRefreshToken(member);

        memberTokenRepositoryJPA.save(MemberTokenDAO.builder()
                .oauthId(member.getOauthId())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .createAt(LocalDateTime.now())
                .refreshTokenExpireAt(LocalDateTime.now().plusDays(7))
                .build());

        String token = jwtUtil.generateToken(accessToken, refreshToken);

        // 필요한 데이터를 리다이렉트 URL에 추가합니다.
        String redirectUrl = "https://pickandlol.iwiwantit.com/#/?token=" + URLEncoder.encode(token, StandardCharsets.UTF_8);

        response.sendRedirect(redirectUrl); // 리다이렉트 수행
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Member member = oAuthService.getCurrentMember(authentication); // 현재 로그인한 사용자의 Member 객체를 가져옵니다.

        String accessToken = jwtUtil.generateAccessToken(member);
        String refreshToken = jwtUtil.generateRefreshToken(member);

        memberTokenRepositoryJPA.save(MemberTokenDAO.builder()
                .oauthId(member.getOauthId())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .createAt(LocalDateTime.now())
                .refreshTokenExpireAt(LocalDateTime.now().plusDays(7))
                .build());

        String token = jwtUtil.generateToken(accessToken, refreshToken);

        // 필요한 데이터를 리다이렉트 URL에 추가합니다.
        String redirectUrl = "https://pickandlol.iwiwantit.com/#/?token=" + URLEncoder.encode(token, StandardCharsets.UTF_8);

        response.sendRedirect(redirectUrl); // 리다이렉트 수행
    }
}
