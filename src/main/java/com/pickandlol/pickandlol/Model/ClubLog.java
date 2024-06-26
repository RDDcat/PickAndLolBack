package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.Enum.MatchType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubLog {
    @Id
    Long matchTeamId;
    MatchType matchType;
    MatchResult matchResult;
    String playTime;
    Integer voidGrubs;
    Integer heralds;
    Integer drakes;
    Integer elders;
    Integer barons;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Long teamId;
    Long topId;
    Long jungleId;
    Long midId;
    Long adcId;
    Long supportId;
    LocalDateTime createdAt;
}
