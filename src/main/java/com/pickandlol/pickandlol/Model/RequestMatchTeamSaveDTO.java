package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.Enum.MatchType;
import lombok.Data;

@Data
public class RequestMatchTeamSaveDTO {
    MatchType matchType;
    MatchResult matchResult;
    String playTime;
    Integer voidGrubs;
    Integer heralds;
    Integer drakes;
    Integer elders;
    Integer barons;
    Long teamId;
    Long topId;
    Long jungleId;
    Long midId;
    Long adcId;
    Long supportId;
}
