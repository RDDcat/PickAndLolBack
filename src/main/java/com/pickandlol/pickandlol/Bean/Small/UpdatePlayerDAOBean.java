package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubDAO;
import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.PlayerDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdatePlayerDAOBean {

    // 선수 정보 업데이트
    public void exec(PlayerDAO playerDAO, List<PlayerLog> playerLogs, ClubDAO clubDAO) {
        double kda;
        int totalStat = 0;
        int totalKillCount = 0;
        int totalDeathCount = 0;
        int totalAssistCount = 0;
        double totalKillRate;
        int totalPlayCount = playerLogs.size();

        for (PlayerLog playerLog : playerLogs) {
            totalKillCount += playerLog.getKillCount();
            totalDeathCount += playerLog.getDeathCount();
            totalAssistCount += playerLog.getAssistCount();
            totalStat += playerLog.getStat();
        }

        kda = totalDeathCount > 0 ? (double) (totalKillCount + totalAssistCount) / totalDeathCount : 0.0;

        totalKillRate = totalPlayCount > 0 ? (double) (totalKillCount + totalAssistCount) / clubDAO.getKillCount() : 0.0;

        // Update the PlayerDAO object
        playerDAO.setStat(totalStat);
        playerDAO.setKillCount(totalKillCount);
        playerDAO.setDeathCount(totalDeathCount);
        playerDAO.setAssistCount(totalAssistCount);
        playerDAO.setKda(kda);
        playerDAO.setKillRate(totalKillRate);
        playerDAO.setPlayCount(totalPlayCount);
    }
}
