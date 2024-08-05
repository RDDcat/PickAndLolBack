package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.jose.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAccessTokenBean {

    JwtUtil jwtUtil;

    @Autowired
    public GetAccessTokenBean(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String exec(String token) {

        boolean validatedToken = jwtUtil.validateToken(token);

        if (!validatedToken) {
            return null;
        }

        return jwtUtil.getAccessToken(token);
    }
}
