package com.pickandlol.pickandlol.Model.DAO;

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
    String clubLogId;
    String matchId;
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
    String clubId;
    String topId;
    String jglId;
    String midId;
    String adcId;
    String supId;
    LocalDateTime createdAt;
}
