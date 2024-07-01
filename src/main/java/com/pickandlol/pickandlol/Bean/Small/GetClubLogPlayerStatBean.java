package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class GetClubLogPlayerStatBean {

    public Integer exec(ClubLog clubLog, RequestPlayerLogSaveDTO playerLog) {

        Long playerId = playerLog.getPlayerId();

        int stat = 10;  // 출전 점수

        Long topId = clubLog.getTopId();
        Long jglId = clubLog.getJglId();
        Long midId = clubLog.getMidId();
        Long adcId = clubLog.getAdcId();
        Long supId = clubLog.getSupId();

        // stat 선정
        stat += playerLog.isMom() ? 40 : 0; // MOM 선정
        stat += playerLog.getHeraldDriveFail() * -20; // 전령 드라이브 실패

        if (playerId.equals(topId)) {
            stat += playerLog.isFirstKill() ? 40 : 0; // 퍼스트 킬
            stat += playerLog.getKillCount() * 10; // 킬 수
            stat += playerLog.getAssistCount() * 10; // 어시스트 수
            stat += playerLog.getDeathCount() * -10; // 데스 수
            stat += playerLog.getSoloKills() * 10; // 솔로 킬
            stat += playerLog.getSoloDeaths() * -10; // 솔로 데스
            stat += playerLog.isFirstDeath() ? -40 : 0; // 퍼스트 데스
        } else if (playerId.equals(jglId)) {
            stat += playerLog.isFirstKill() ? 30 : 0; // 퍼스트 킬
            stat += playerLog.getKillCount() * 10; // 킬 수
            stat += playerLog.getAssistCount() * 10; // 어시스트 수
            stat += playerLog.getDeathCount() * -10; // 데스 수
        } else if (playerId.equals(midId)) {
            stat += playerLog.isFirstKill() ? 30 : 0; // 퍼스트 킬
            stat += playerLog.getKillCount() * 20; // 킬 수
            stat += playerLog.getAssistCount() * 10; // 어시스트 수
            stat += playerLog.getDeathCount() * -20; // 데스 수
        } else if (playerId.equals(adcId)) {
            stat += playerLog.isFirstKill() ? 30 : 0; // 퍼스트 킬
            stat += playerLog.getKillCount() * 15; // 킬 수
            stat += playerLog.getAssistCount() * 10; // 어시스트 수
            stat += playerLog.getDeathCount() * -20; // 데스 수
        } else if (playerId.equals(supId)) {
            stat += playerLog.isFirstKill() ? 20 : 0; // 퍼스트 킬
            stat += playerLog.getKillCount() * 20; // 킬 수
            // 2어시 당 15점
            // 어시스트 수
            stat += (playerLog.getAssistCount()/2) * 15; // 어시스트 수
            stat += (playerLog.getDeathCount()/2) * -15; // 데스 수
        }

        return stat;
    }
}
