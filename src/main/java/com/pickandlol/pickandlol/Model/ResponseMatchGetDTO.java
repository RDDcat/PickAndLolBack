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
    Integer year;
    Integer month;
    Integer day;
    String dayOfTheWeek;
    String time;
    String round;
    Integer homeScore;
    Integer awayScore;
    String matchStatus;
    String clubLogId;
}
