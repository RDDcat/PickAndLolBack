package com.pickandlol.pickandlol.Model.DTO;

import lombok.Data;

@Data
public class RequestMatchSaveDTO {
    String matchSeason;
    String matchNum;
    String homeClubId;
    String awayClubId;
    String stadium;
    Integer year;
    Integer month;
    Integer day;
    String time;
    String round;
}
