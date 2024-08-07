package com.pickandlol.pickandlol.Model.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PlayerVPLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long playerVPLogId;
    String playerId;
    Integer vp;
    Integer vpUpdateDate;
}
