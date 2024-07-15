package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.Week;
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
    String playerLogId;
    String clubLogId;
    String playerId;
    Integer stat;
    boolean isFirstKill;
    boolean isFirstDeath;
    boolean isPog;
    Integer heraldDriveFail;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Integer soloKills;
    Integer soloDeaths;
    Integer damage;
    Integer cs;
    Integer playTime;
    String date;
    Week week;
    LocalDateTime createAt;
}
