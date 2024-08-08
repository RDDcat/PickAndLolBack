package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateTeamLogDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetTeamLogDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveTeamLogDAOBean;
import com.pickandlol.pickandlol.Model.DTO.RequestTeamLogSaveDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamLogBean {

    CreateTeamLogDAOBean createTeamLogDAOBean;
    GetTeamLogDAOBean getTeamLogDAOBean;
    SaveTeamLogDAOBean saveTeamLogDAOBean;

    @Autowired
    public SaveTeamLogBean(CreateTeamLogDAOBean createTeamLogDAOBean, GetTeamLogDAOBean getTeamLogDAOBean, SaveTeamLogDAOBean saveTeamLogDAOBean) {
        this.createTeamLogDAOBean = createTeamLogDAOBean;
        this.getTeamLogDAOBean = getTeamLogDAOBean;
        this.saveTeamLogDAOBean = saveTeamLogDAOBean;
    }

    public String exec(RequestTeamLogSaveDTO requestTeamLogSaveDTO){

        TeamLog teamLog = createTeamLogDAOBean.exec(requestTeamLogSaveDTO);

        TeamLog teamLog1 = getTeamLogDAOBean.exec(requestTeamLogSaveDTO.getOauthId());
        if (teamLog1 != null){
            teamLog1.setUpdateDate(teamLog.getCreateDate());
            saveTeamLogDAOBean.exec(teamLog1);
        }

        saveTeamLogDAOBean.exec(teamLog);

        return "success";
    }
}
