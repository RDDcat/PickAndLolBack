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
    String playerTeam;
    Integer stat;
    Double kda;
    Integer kill;
    Integer death;
    Integer assist;
    Double killRate;
    Integer playCount;
}
