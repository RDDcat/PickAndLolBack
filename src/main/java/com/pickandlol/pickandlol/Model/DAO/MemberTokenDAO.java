package com.pickandlol.pickandlol.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberTokenDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long memberTokenId;
    String oauthId;
    String accessToken;
    String refreshToken;
    LocalDateTime createAt;
    LocalDateTime refreshTokenExpireAt;
}
