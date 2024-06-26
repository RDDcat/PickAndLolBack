package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.PlayerDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdatePlayerDAOBean {

    // 선수 정보 업데이트
    // stat와 킬 관여율 추기 예정
    public void exec(PlayerDAO playerDAO, List<PlayerLog> playerLogs) {
        int stat = 0;
        double kda;
        int totalKillCount = 0;
        int totalDeathCount = 0;
        int totalAssistCount = 0;
        double totalKillRate = 0.0;
        int totalPlayCount = playerLogs.size();

        for (PlayerLog playerLog : playerLogs) {
            totalKillCount += playerLog.getKillCount();
            totalDeathCount += playerLog.getDeathCount();
            totalAssistCount += playerLog.getAssistCount();
        }

        kda = totalDeathCount > 0 ? (double) (totalKillCount + totalAssistCount) / totalDeathCount : 0.0;

        // Update the PlayerDAO object
        playerDAO.setKillCount(totalKillCount);
        playerDAO.setDeathCount(totalDeathCount);
        playerDAO.setAssistCount(totalAssistCount);
        playerDAO.setKda(kda);
        playerDAO.setPlayCount(totalPlayCount);
    }
}
