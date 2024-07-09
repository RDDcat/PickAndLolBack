package com.pickandlol.pickandlol.Model;

import com.pickandlol.pickandlol.Model.Enum.Week;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TeamStatisticDAO {
    @Id
    Long teamStatisticId;
    String oauthId;
    Week week;
    Integer score;
}
