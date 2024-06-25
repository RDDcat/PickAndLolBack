package com.pickandlol.pickandlol.Model;

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
public class TeamsDAO {
    @Id
    Long teamId;
    String teamLogo;
    String teamName;
    Integer winCount;
    Integer loseCount;
    Integer totalGap;
    Integer winRate;
    Double kda;
    Integer kill;
    Integer death;
    Integer assist;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
