package com.pickandlol.pickandlol.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TeamLog {
    @Id
    String teamLogId;
    String oauthId;
    String topId;
    String jglId;
    String midId;
    String adcId;
    String supId;
    String mvpId;
    String createDate;
    String updateDate;
}
