package com.pickandlol.pickandlol.Model.DTO;

import com.pickandlol.pickandlol.Model.Enum.PlayerPosition;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPlayerLogSaveDTO {
    String clubLogId;
    String playerId;
    boolean isFirstKill;  // 퍼스트 킬
    boolean isFirstDeath; // 퍼스트 데스
    boolean isPog; // MOM 선정
    Integer heraldDriveFail; // 전령 드라이브 실패 횟수
    Integer killCount; // 킬
    Integer deathCount; // 데스
    Integer assistCount; // 어시스트
    Integer soloKills; // 솔로킬
    Integer soloDeaths; // 솔로데스
    Integer damage; // 데미지
    Integer cs; // CS
}
