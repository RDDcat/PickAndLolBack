package com.pickandlol.pickandlol.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTeamSaveDTO {
    String oauthId;
    String data;
    boolean canChange;
}
