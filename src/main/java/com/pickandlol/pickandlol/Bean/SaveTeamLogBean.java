package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateTeamLogDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetPlayerVPLogDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetTeamLogDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveTeamLogDAOBean;
import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import com.pickandlol.pickandlol.Model.DTO.RequestTeamLogSaveDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamLogBean {

    GetPlayerVPLogDAOBean getPlayerVPLogDAOBean;
    CreateTeamLogDAOBean createTeamLogDAOBean;
    GetTeamLogDAOBean getTeamLogDAOBean;
    SaveTeamLogDAOBean saveTeamLogDAOBean;

    private static final String DEFAULT_PLAYER_ID = "0";

    @Autowired
    public SaveTeamLogBean(GetPlayerVPLogDAOBean getPlayerVPLogDAOBean, CreateTeamLogDAOBean createTeamLogDAOBean, GetTeamLogDAOBean getTeamLogDAOBean, SaveTeamLogDAOBean saveTeamLogDAOBean) {
        this.getPlayerVPLogDAOBean = getPlayerVPLogDAOBean;
        this.createTeamLogDAOBean = createTeamLogDAOBean;
        this.getTeamLogDAOBean = getTeamLogDAOBean;
        this.saveTeamLogDAOBean = saveTeamLogDAOBean;
    }

    public String exec(RequestTeamLogSaveDTO requestTeamLogSaveDTO){

        // 선수 vp 마지막 업데이트 날
        PlayerVPLog playerVPLog = getPlayerVPLogDAOBean.exec(DEFAULT_PLAYER_ID);
        if (playerVPLog == null) return null;
        Integer updateDate = playerVPLog.getVpUpdateDate();

        TeamLog teamLog = createTeamLogDAOBean.exec(updateDate, requestTeamLogSaveDTO);

        TeamLog teamLog1 = getTeamLogDAOBean.exec(requestTeamLogSaveDTO.getOauthId());
        if (teamLog1 != null){
            teamLog1.setUpdateDate(teamLog.getCreateDate());
            saveTeamLogDAOBean.exec(teamLog1);
        }

        saveTeamLogDAOBean.exec(teamLog);

        return "success";
    }
}
