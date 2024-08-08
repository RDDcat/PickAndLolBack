package com.pickandlol.pickandlol.Model.DAO;

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
    String teamStatisticId;
    String oauthId;
    Week week;
    Integer score;
}
