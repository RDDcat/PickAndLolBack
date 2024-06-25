package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import com.pickandlol.pickandlol.Model.TeamsDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateTeamDAOBean {

    public void exec(TeamsDAO teamsDAO, List<MatchTeamDAO> matchTeamDAOS) {
        int totalWinCount = 0;
        int totalLoseCount = 0;
        int totalKillCount = 0;
        int totalDeathCount = 0;
        int totalAssistCount = 0;
        int totalGap;
        double totalKDA;
        double winRate;

        for (MatchTeamDAO matchTeamDAO : matchTeamDAOS) {
            totalWinCount += matchTeamDAO.getMatchResult() == MatchResult.Win ? 1 : 0;
            totalLoseCount += matchTeamDAO.getMatchResult() == MatchResult.Lose ? 1 : 0;
            totalKillCount += matchTeamDAO.getKillCount();
            totalDeathCount += matchTeamDAO.getDeathCount();
            totalAssistCount += matchTeamDAO.getAssistCount();
        }

        if (totalDeathCount > 0) {
            totalKDA = (double) (totalKillCount + totalAssistCount) / totalDeathCount;
        }
        else totalKDA = 0.0;

        // 득실차
        totalGap = totalKillCount - totalDeathCount;

        // 승률
        if (totalWinCount + totalLoseCount > 0 && totalWinCount - totalLoseCount >= 0) {
            winRate = (double) totalWinCount / (totalWinCount + totalLoseCount);
        }
        else winRate = 0.0;


        // Update the TeamsDAO object
        teamsDAO.setWinCount(totalWinCount);
        teamsDAO.setLoseCount(totalLoseCount);
        teamsDAO.setKillCount(totalKillCount);
        teamsDAO.setDeathCount(totalDeathCount);
        teamsDAO.setAssistCount(totalAssistCount);
        teamsDAO.setKda(totalKDA);
        teamsDAO.setTotalGap(totalGap);
        teamsDAO.setWinRate(winRate);
    }
}
