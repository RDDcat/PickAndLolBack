package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.PlayerPosition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPlayerLogSaveDTO {
    Long matchClubId;
    PlayerPosition playerPosition;
    Long playerId;
    boolean firstKill;
    boolean firstDeath;
    boolean mom;
    Integer heraldDriveFail;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    boolean soloKill;
    boolean soloDeaths;
}
