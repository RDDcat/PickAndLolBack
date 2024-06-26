package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResponseClubGetDTO {
    Long teamId;
    String teamLogo;
    String teamName;
    Integer winCount;
    Integer loseCount;
    Integer totalGap;
    Double winRate;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
}
