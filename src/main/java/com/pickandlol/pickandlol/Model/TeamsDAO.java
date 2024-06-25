package com.pickandlol.pickandlol.Model;

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
public class TeamsDAO {
    @Id
    Long teamId;
    String teamLogo;
    String teamName;
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
