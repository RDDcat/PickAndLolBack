package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateClubDAOBean {

    GetMatchsByWinnerClubIdDAOBean getMatchsByWinnerClubIdDAOBean;
    GetMatchByLoserClubIdDAOBean getMatchByLoserClubIdDAOBean;

    @Autowired
    public UpdateClubDAOBean(GetMatchsByWinnerClubIdDAOBean getMatchsByWinnerClubIdDAOBean, GetMatchByLoserClubIdDAOBean getMatchByLoserClubIdDAOBean) {
        this.getMatchsByWinnerClubIdDAOBean = getMatchsByWinnerClubIdDAOBean;
        this.getMatchByLoserClubIdDAOBean = getMatchByLoserClubIdDAOBean;
    }

    public void exec(ClubDAO clubDAO, List<ClubLog> clubLogs) {
        int totalWinCount = 0;
        int totalLoseCount = 0;
        int totalKillCount = 0;
        int totalDeathCount = 0;
        int totalAssistCount = 0;
        int totalMatchWinCount;
        int totalMatchLoseCount;
        int totalGap;
        double totalKDA;
        double winRate;

        for (ClubLog clubLog : clubLogs) {
            totalWinCount += clubLog.getMatchResult() == MatchResult.WIN ? 1 : 0;
            totalLoseCount += clubLog.getMatchResult() == MatchResult.LOSE ? 1 : 0;
            totalKillCount += clubLog.getKillCount();
            totalDeathCount += clubLog.getDeathCount();
            totalAssistCount += clubLog.getAssistCount();
        }

        if (totalDeathCount > 0) {
            totalKDA = (double) (totalKillCount + totalAssistCount) / totalDeathCount;
        }
        else totalKDA = 0.0;

        // 득실차
        totalGap = totalWinCount - totalLoseCount;

        // 승률
        if (totalWinCount + totalLoseCount > 0 && totalWinCount - totalLoseCount >= 0) {
            winRate = (double) totalWinCount / (totalWinCount + totalLoseCount);
        }
        else winRate = 0.0;

        // 매치 승/패
        totalMatchWinCount = getMatchsByWinnerClubIdDAOBean.exec(clubDAO.getClubId()).size();
        totalMatchLoseCount = getMatchByLoserClubIdDAOBean.exec(clubDAO.getClubId()).size();


        // Update the TeamsDAO object
        clubDAO.setMatchWinCount(totalMatchWinCount);
        clubDAO.setMatchLoseCount(totalMatchLoseCount);
        clubDAO.setWinCount(totalWinCount);
        clubDAO.setLoseCount(totalLoseCount);
        clubDAO.setKillCount(totalKillCount);
        clubDAO.setDeathCount(totalDeathCount);
        clubDAO.setAssistCount(totalAssistCount);
        clubDAO.setKda(totalKDA);
        clubDAO.setTotalGap(totalGap);
        clubDAO.setWinRate(winRate);
    }
}
