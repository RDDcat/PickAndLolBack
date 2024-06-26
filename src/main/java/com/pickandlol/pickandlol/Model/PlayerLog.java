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
public class PlayerLog {
    @Id
    Long playerLogId;
    Long clubLogId;
    Long playerId;
    Integer stat;
    boolean firstKill;
    boolean firstDeath;
    boolean mom;
    Integer heraldDriveFail;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Integer soloKills;
    Integer soloDeaths;
    LocalDateTime createAt;
}
