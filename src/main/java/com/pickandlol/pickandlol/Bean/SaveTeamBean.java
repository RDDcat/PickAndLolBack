package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetTeamByOauthIdDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveTeamDAOBean;
import com.pickandlol.pickandlol.Model.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Model.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamBean {

    GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean;
    SaveTeamDAOBean saveTeamDAOBean;

    @Autowired
    public SaveTeamBean(GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean, SaveTeamDAOBean saveTeamDAOBean) {
        this.getTeamByOauthIdDAOBean = getTeamByOauthIdDAOBean;
        this.saveTeamDAOBean = saveTeamDAOBean;
    }

    public String exec(RequestTeamSaveDTO requestTeamSaveDTO){

        // update
        TeamDAO teamDAO1 = getTeamByOauthIdDAOBean.exec(requestTeamSaveDTO.getOauthId());
        if (teamDAO1 != null) {
            teamDAO1.setData(requestTeamSaveDTO.getData());
            saveTeamDAOBean.exec(teamDAO1);
            return "server update";
        };

        TeamDAO teamDAO = TeamDAO.builder()
                .data(requestTeamSaveDTO.getData())
                .oauthId(requestTeamSaveDTO.getOauthId())
                .isChanged(false)
                .build();

        saveTeamDAOBean.exec(teamDAO);

        return "server save";
    }
}
