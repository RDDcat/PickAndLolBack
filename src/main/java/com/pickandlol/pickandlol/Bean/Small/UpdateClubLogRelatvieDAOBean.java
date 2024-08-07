package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.ClubLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateClubLogRelatvieDAOBean {

    private static final int  OneTeamSet= 1;
    private static final int  TwoTeamSet= 2;

    GetClubLogByMatchIdByOrderSetDAOBean getClubLogByMatchIdByOrderSetDAOBean;
    SaveClubLogDAOBean saveClubLogDAOBean;

    @Autowired
    public UpdateClubLogRelatvieDAOBean(GetClubLogByMatchIdByOrderSetDAOBean getClubLogByMatchIdByOrderSetDAOBean, SaveClubLogDAOBean saveClubLogDAOBean){
        this.getClubLogByMatchIdByOrderSetDAOBean = getClubLogByMatchIdByOrderSetDAOBean;
        this.saveClubLogDAOBean = saveClubLogDAOBean;
    }

    public void exec(ClubLog clubLog){

        // matchId랑 orderSet이랑 조회떄려
        List<ClubLog> clubLogList = getClubLogByMatchIdByOrderSetDAOBean.exec(clubLog.getMatchId(), clubLog.getOrderSet());

        // 1개면 냅두고
        if (clubLogList.size() == OneTeamSet) return;
        else if (clubLogList.size() == TwoTeamSet){
            // 2개면 현재 들어온애를 나머지 하나로 업데이트해주고 나머지 하나의 값도 현재 들어온걸로 업데이트 해줘야해
            ClubLog clubLog1 = clubLogList.get(OneTeamSet);
            ClubLog clubLog2 = clubLogList.get(0);

            clubLog1.setRelativeVoidGrubsCount(clubLog1.getVoidGrubs() - clubLog2.getVoidGrubs());
            clubLog1.setRelativeDrakesCount(clubLog1.getDrakes() - clubLog2.getDrakes());
            clubLog1.setRelativeBaronsCount(clubLog1.getBarons() - clubLog2.getBarons());
            clubLog1.setRelativeHeraldsCount(clubLog1.getHeralds() - clubLog2.getHeralds());
            clubLog1.setRelativeEldersCount(clubLog1.getElders() - clubLog2.getElders());

            clubLog2.setRelativeVoidGrubsCount(clubLog2.getVoidGrubs() - clubLog1.getVoidGrubs());
            clubLog2.setRelativeDrakesCount(clubLog2.getDrakes() - clubLog1.getDrakes());
            clubLog2.setRelativeBaronsCount(clubLog2.getBarons() - clubLog1.getBarons());
            clubLog2.setRelativeHeraldsCount(clubLog2.getHeralds() - clubLog1.getHeralds());
            clubLog2.setRelativeEldersCount(clubLog2.getElders() - clubLog1.getElders());


            saveClubLogDAOBean.exec(clubLog2);
            saveClubLogDAOBean.exec(clubLog1);
        }

    }
}
