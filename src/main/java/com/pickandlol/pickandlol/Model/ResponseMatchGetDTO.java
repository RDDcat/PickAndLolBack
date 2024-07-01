package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMatchGetDTO {
    Long matchId;
    String matchNum;
    Long homeClubId;
    Long awayClubId;
    String stadium;
    Long year;
    Long month;
    Long day;
    String dayOfTheWeek;
    String time;
    String round;
    Long homeScore;
    Long awayScore;
    String matchStatus;
    String clubLogId;
}
