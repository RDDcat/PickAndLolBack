package com.pickandlol.pickandlol.Model;

import lombok.Data;

@Data
public class RequestMatchSaveDTO {
    String matchType;
    String matchNum;
    Long homeClubId;
    Long awayClubId;
    String stadium;
    Integer year;
    Integer month;
    Integer day;
    String time;
    String round;
}
