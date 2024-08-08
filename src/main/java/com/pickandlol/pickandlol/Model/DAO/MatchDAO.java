package com.pickandlol.pickandlol.Model.DAO;

import com.pickandlol.pickandlol.Model.Enum.MatchSeason;
import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDAO {
    @Id
    String matchId;
    MatchSeason matchSeason;
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
    MatchStatus matchStatus;
    String winnerClubId;
    String loserClubId;
    String clubLogId; // list
}
