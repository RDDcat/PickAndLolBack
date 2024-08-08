package com.pickandlol.pickandlol.Model.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponsePlayerGetDTO {
    String playerId;
    String playerName;
    String playerImage;
    String playerPosition;
    List<String> playerInfo;
    String clubId;
    Integer stat;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Integer soloKillCount;
    Double killRate;
    Double damage;
    Double cs;
    Integer playCount;
    Integer vp;
    Integer rank;
}
