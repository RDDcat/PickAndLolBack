package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.Enum.MatchType;
import lombok.Data;

@Data
public class RequestClubLogSaveDTO {
    Long matchId;
    MatchType matchType;
    MatchResult matchResult;
    String playTime;
    Integer voidGrubs;
    Integer heralds;
    Integer drakes;
    Integer elders;
    Integer barons;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Long clubId;
    Long topId;
    Long jglId;
    Long midId;
    Long adcId;
    Long supId;
}