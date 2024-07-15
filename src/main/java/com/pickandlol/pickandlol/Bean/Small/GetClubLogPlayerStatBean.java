package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import org.springframework.stereotype.Component;

@Component
public class GetClubLogPlayerStatBean {

    public Integer exec(ClubLog clubLog, RequestPlayerLogSaveDTO playerLog) {

        String playerId = playerLog.getPlayerId();

        int stat = 10;  // 출전 점수

        String topId = clubLog.getTopId();
        String jglId = clubLog.getJglId();
        String midId = clubLog.getMidId();
        String adcId = clubLog.getAdcId();
        String supId = clubLog.getSupId();

        // stat 선정
        stat += playerLog.isPog() ? 40 : 0; // MOM 선정
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

            // 오브젝트 관련 점수
            stat += clubLog.getRelativeDrakesCount() * 10; // 드래곤 수
            stat += clubLog.getRelativeEldersCount() * 20; // 장로 수
            stat += (clubLog.getRelativeVoidGrubsCount()) / 2 * 10; // 유충 수
            stat += clubLog.getRelativeHeraldsCount() * 10; // 전령 수
            stat += clubLog.getRelativeBaronsCount() * 20; // 바론 수
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

        return Math.max(stat, 0);

    }
}
