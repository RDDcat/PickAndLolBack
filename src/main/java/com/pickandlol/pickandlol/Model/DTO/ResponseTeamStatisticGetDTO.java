package com.pickandlol.pickandlol.Model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTeamStatisticGetDTO {
    String oauthId;
    Integer weekStat;
    Integer totalStat;
}
