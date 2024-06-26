package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.Enum.MatchType;
import com.pickandlol.pickandlol.Model.Enum.OrderSet;
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
    Long clubLogId;
    Long matchId;
    MatchType matchType;
    MatchResult matchResult;
    OrderSet orderSet;
    String playTime;
    Integer voidGrubs;
    Integer heralds;
    Integer drakes;
    Integer elders;
    Integer barons;
    Integer killCount;
    Integer deathCount;
    Integer assistCount;
    Integer relativeVoidGrubsCount;
    Integer relativeDrakesCount;
    Integer relativeBaronsCount;
    Integer relativeHeraldsCount;
    Integer relativeEldersCount;
    Long clubId;
    Long topId;
    Long jglId;
    Long midId;
    Long adcId;
    Long supId;
    LocalDateTime createdAt;
}
