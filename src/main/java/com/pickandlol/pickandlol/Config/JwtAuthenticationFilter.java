package com.pickandlol.pickandlol.Config;

import com.pickandlol.pickandlol.Model.MemberTokenDAO;
import com.pickandlol.pickandlol.Repository.MemberTokenRepositoryJPA;
import com.pickandlol.pickandlol.jose.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final MemberTokenRepositoryJPA memberTokenRepositoryJPA;
    private static final List<String> EXCLUDE_URLS = List.of("/club/all", "/health", "/error", "/favicon.ico", "/match", "/match/**", "/player/all", "/team/statistic", "/rank", "/team/log", "/team/change/**", "/token/**", "/refresh");
    public JwtAuthenticationFilter(JwtUtil jwtUtil, MemberTokenRepositoryJPA memberTokenRepositoryJPA) {
        this.jwtUtil = jwtUtil;
        this.memberTokenRepositoryJPA = memberTokenRepositoryJPA;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();

        // 예외 경로 필터링하지 않도록 설정
        if (EXCLUDE_URLS.stream().anyMatch(path::matches)) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = request.getHeader("access-token");

        // 토큰으로 멤버 찾기
        MemberTokenDAO memberTokenDAO = memberTokenRepositoryJPA.findByAccessToken(accessToken);
        if (memberTokenDAO == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        else {
            // Access Token 유효성 검사
            if (!jwtUtil.validateToken(accessToken)) {
                // Access Token이 만료된 경우
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }

            // 인증 설정
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(memberTokenDAO.getOauthId(), null, null);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 필터로 진행
        filterChain.doFilter(request, response);
    }
}