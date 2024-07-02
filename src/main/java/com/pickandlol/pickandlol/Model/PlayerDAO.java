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
public class PlayerDAO {
    @Id
    Long playerId;
    Long clubId;
    String playerName;
    String playerImage;
    String playerPosition;
    Integer stat;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Double killRate;
    Integer playCount;
    LocalDateTime createAt;
}
