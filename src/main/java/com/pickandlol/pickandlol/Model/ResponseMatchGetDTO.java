package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMatchGetDTO {
    String matchId;
    String matchNum;
    String homeClubId;
    String awayClubId;
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
