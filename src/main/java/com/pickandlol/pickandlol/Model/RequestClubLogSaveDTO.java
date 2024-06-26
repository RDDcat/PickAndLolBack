package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.Enum.MatchType;
import lombok.Data;

@Data
public class RequestClubLogSaveDTO {
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
    Long teamId;
    Long topId;
    Long jungleId;
    Long midId;
    Long adcId;
    Long supportId;
}
