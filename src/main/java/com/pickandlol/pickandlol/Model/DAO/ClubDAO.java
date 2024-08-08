package com.pickandlol.pickandlol.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubDAO {
    @Id
    String clubId;
    String clubLogo;
    String clubName;
    Integer matchWinCount;
    Integer matchLoseCount;
    Integer winCount;
    Integer loseCount;
    Integer totalGap;
    Double winRate;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
