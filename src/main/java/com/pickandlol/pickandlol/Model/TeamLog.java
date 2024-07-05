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
    Long teamLogId;
    Long userId;
    Long topId;
    Long jglId;
    Long midId;
    Long adcId;
    Long supId;
    String createDate;
    String updateDate;
}
