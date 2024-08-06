package com.pickandlol.pickandlol.jose;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.MemberTokenDAO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long JWT_EXPIRE_TIME = 1000 * 60 * 10L;
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30L;
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60L * 24 * 7;

    public String generateToken(String accessToken, String refreshToken) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + JWT_EXPIRE_TIME);

        return Jwts.builder()
                .claim("accessToken", accessToken)
                .claim("refreshToken", refreshToken)
                .issuedAt(now)
                .expiration(expiredDate)
                .signWith(key)
                .compact();
    }

    public String generateAccessToken(Member member) {
        return generateOauthToken(member.getOauthId(), ACCESS_TOKEN_EXPIRE_TIME);
    }

    public String generateAccessToken(MemberTokenDAO memberTokenDAO) {
        return generateOauthToken(memberTokenDAO.getOauthId(), ACCESS_TOKEN_EXPIRE_TIME);
    }

    public String generateRefreshToken(Member member) {
        return generateOauthToken(member.getOauthId(), REFRESH_TOKEN_EXPIRE_TIME);
    }

    private String generateOauthToken(String oauthId, long expireTime) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + expireTime);

        return Jwts.builder()
                .subject(oauthId)
                .issuedAt(now)
                .expiration(expiredDate)
                .signWith(key)
                .compact();
    }

    // JWT 토큰의 유효성 검사 메서드
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith((SecretKey) key)
                    .build()
                    .parseSignedClaims(token);

            Claims claims = claimsJws.getPayload();
            Date expiration = claims.getExpiration();

            // 만료 시간 확인 후, 만료되었으면 false 반환
            return expiration.after(new Date());
        } catch (Exception e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }

    public String getAccessToken(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("accessToken", String.class);
    }
}
