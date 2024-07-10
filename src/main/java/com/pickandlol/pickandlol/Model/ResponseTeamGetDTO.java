package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseTeamGetDTO {
    String oauthId;
    String data;
    boolean canChange;
}
