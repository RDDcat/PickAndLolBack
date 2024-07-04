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
    Long playerId;
    Long clubId;
    MatchSeason matchSeason;
    String playerName;
    String playerImage;
    String playerPosition;
    Integer stat;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Integer damage;
    Integer cs;
    Integer playTime;
    Double killRate;
    Integer playCount;
    LocalDateTime createAt;
}
