package com.pickandlol.pickandlol.Config;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Repository.MemberRepositoryJPA;
import com.pickandlol.pickandlol.jose.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    MemberRepositoryJPA memberRepositoryJPA;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, MemberRepositoryJPA memberRepositoryJPA) {
        this.jwtUtil = jwtUtil;
        this.memberRepositoryJPA = memberRepositoryJPA;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = request.getHeader("access-token");

        // 토큰으로 멤버 찾기
        Member member = memberRepositoryJPA.findByAccessToken(accessToken);
        if (member != null) {
            // Access Token 유효성 검사
            if (!jwtUtil.validateToken(accessToken)) {
                // Access Token이 만료된 경우 Refresh Token 유효성 검사
                if (jwtUtil.validateToken(member.getRefreshToken())) {
                    // Refresh Token이 유효한 경우 새로운 Access Token 발급
                    String newAccessToken = jwtUtil.generateAccessToken(member);

                    // 멤버 객체 업데이트 및 저장
                    member.setAccessToken(newAccessToken);
                    memberRepositoryJPA.save(member);

                } else {
                    // Refresh Token도 만료된 경우 응답 설정
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
            }

            // 인증 설정
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(member.getOauthId(), null, null);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 필터로 진행
        filterChain.doFilter(request, response);
    }
}