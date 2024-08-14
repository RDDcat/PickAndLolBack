package com.pickandlol.pickandlol.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {
    @JsonProperty("isMvp")
    boolean isMvp;
    String name;
    String team;
    int vp;
    String img;
    String id;
}
