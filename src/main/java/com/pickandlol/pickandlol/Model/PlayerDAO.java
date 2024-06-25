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
    String playerName;
    String playerImage;
    String playerPosition;
    String playerTeam;
    Integer stat;
    Double kda;
    Integer kill;
    Integer death;
    Integer assist;
    Double killRate;
    Integer playCount;
    LocalDateTime createAt;
}
