package com.pickandlol.pickandlol.Model;

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
    Long winnerTeamId;
    Long loserTeamId;
    String clubLogId;
}
