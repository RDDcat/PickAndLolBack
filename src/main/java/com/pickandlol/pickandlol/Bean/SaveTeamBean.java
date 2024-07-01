package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.SaveTeamDAOBean;
import com.pickandlol.pickandlol.Model.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Model.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamBean {

    SaveTeamDAOBean saveTeamDAOBean;

    @Autowired
    public SaveTeamBean(SaveTeamDAOBean saveTeamDAOBean) {
        this.saveTeamDAOBean = saveTeamDAOBean;
    }

    public String exec(RequestTeamSaveDTO requestTeamSaveDTO){

        TeamDAO teamDAO = TeamDAO.builder()
                .data(requestTeamSaveDTO.getData())
                .oauthId(requestTeamSaveDTO.getOauthId())
                .build();

        saveTeamDAOBean.exec(teamDAO);

        return "server save";
    }
}
