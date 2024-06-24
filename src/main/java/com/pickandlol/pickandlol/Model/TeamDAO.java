package com.pickandlol.pickandlol.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long teamId;
    String oauthId;
    String data;

}
