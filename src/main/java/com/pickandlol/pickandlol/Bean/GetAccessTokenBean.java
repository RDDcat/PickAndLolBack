package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.jose.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetAccessTokenBean {

    JwtUtil jwtUtil;

    @Autowired
    public GetAccessTokenBean(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public Map<String, String> exec(String token) {

        boolean validatedToken = jwtUtil.validateToken(token);

        if (!validatedToken) {
            return null;
        }

        String accessToken = jwtUtil.getAccessToken(token);
        String refreshToken = jwtUtil.getRefreshToken(token);

        System.out.println("accessToken = " + accessToken);
        System.out.println("refreshToken = " + refreshToken);


        // 액세스, 리프레쉬 토큰 Map에 담아 반환
        return Map.of("accessToken", accessToken, "refreshToken", refreshToken);
    }
}
