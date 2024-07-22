package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchSeason;
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
public class PlayerDAO {
    @Id
    String playerId;
    String clubId;
    MatchSeason matchSeason;
    String playerName;
    String playerImage;
    String playerPosition;
    String playerInfo;
    Integer stat;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Integer soloKillCount;
    Integer damage;
    Integer cs;
    Integer playTime;
    Double killRate;
    Integer playCount;
    Integer vp;
    LocalDateTime createAt;
}
