package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ResponseClubGetDTO {
    String clubId;
    String clubLogo;
    String clubName;
    Integer matchWinCount;
    Integer matchLoseCount;
    Integer winCount;
    Integer loseCount;
    Integer totalGap;
    Double winRate;
    Double kda;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
}
