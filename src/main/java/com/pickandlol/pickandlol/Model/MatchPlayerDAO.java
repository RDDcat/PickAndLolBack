package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.PlayerPosition;
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
public class MatchPlayerDAO {
    @Id
    Long matchPlayerId;
    Long matchClubId;
    Long playerId;
    boolean firstKill;
    boolean firstDeath;
    boolean mom;
    Integer heraldDriveFail;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    boolean soloKills;
    boolean soloDeaths;
    LocalDateTime createAt;
}
