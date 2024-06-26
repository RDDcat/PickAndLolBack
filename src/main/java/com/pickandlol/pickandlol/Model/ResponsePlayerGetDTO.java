package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponsePlayerGetDTO {
    Long playerId;
    String playerName;
    String playerImage;
    String playerPosition;
    String playerClub;
    Integer stat;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Double killRate;
    Integer playCount;
}
