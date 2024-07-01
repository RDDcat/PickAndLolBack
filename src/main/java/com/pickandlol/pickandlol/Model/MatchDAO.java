package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
import com.pickandlol.pickandlol.Model.Enum.WinnerClubType;
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
    Long matchId;
    String matchType; // ??
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
    WinnerClubType winnerClubType;
    MatchStatus matchStatus;
    Long winnerClubId;
    Long loserClubId;
    String clubLogId;
}
