package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateClubLogRelatvieDAOBean {

    private static final int  OneTeamSet= 1;
    private static final int  TwoTeamSet= 2;

    GetClubLogByMatchIdByOrderSetDAOBean getClubLogByMatchIdByOrderSetDAOBean;

    @Autowired
    public UpdateClubLogRelatvieDAOBean(GetClubLogByMatchIdByOrderSetDAOBean getClubLogByMatchIdByOrderSetDAOBean){
        this.getClubLogByMatchIdByOrderSetDAOBean = getClubLogByMatchIdByOrderSetDAOBean;
    }

    public void exec(ClubLog clubLog){

        // matchId랑 orderSet이랑 조회떄려
        List<ClubLog> clubLogList = getClubLogByMatchIdByOrderSetDAOBean.exec(clubLog.getMatchId(), clubLog.getOrderSet());

        // 1개면 냅두고
        if (clubLogList.size() == OneTeamSet) return;
        else if (clubLogList.size() == TwoTeamSet){
            // 2개면 현재 들어온애를 나머지 하나로 업데이트해주고 나머지 하나의 값도 현재 들어온걸로 업데이트 해줘야해
            ClubLog clubLog1 = clubLogList.get(OneTeamSet);
            clubLog1.setRelativeVoidGrubsCount(clubLog1.getVoidGrubs() - clubLog.getVoidGrubs());
            clubLog1.setRelativeDrakesCount(clubLog1.getDrakes() - clubLog.getDrakes());
            clubLog1.setRelativeBaronsCount(clubLog1.getBarons() - clubLog.getBarons());
            clubLog1.setRelativeHeraldsCount(clubLog1.getHeralds() - clubLog.getHeralds());
            clubLog1.setRelativeEldersCount(clubLog1.getElders() - clubLog.getElders());

            clubLog.setRelativeVoidGrubsCount(clubLog.getVoidGrubs() - clubLog1.getVoidGrubs());
            clubLog.setRelativeDrakesCount(clubLog.getDrakes() - clubLog1.getDrakes());
            clubLog.setRelativeBaronsCount(clubLog.getBarons() - clubLog1.getBarons());
            clubLog.setRelativeHeraldsCount(clubLog.getHeralds() - clubLog1.getHeralds());
            clubLog.setRelativeEldersCount(clubLog.getElders() - clubLog1.getElders());
        }

    }
}
