package com.pickandlol.pickandlol.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMemberGetDTO {
    String name;
    String oauthId;
}
