package com.pickandlol.pickandlol.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamDAO {
    @Id
    Long teamId;
    Long userId;
    String data;

}
