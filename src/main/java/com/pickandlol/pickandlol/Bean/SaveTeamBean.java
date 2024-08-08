package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetTeamByOauthIdDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveTeamDAOBean;
import com.pickandlol.pickandlol.Model.DTO.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
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
            teamDAO1.setCanChange(requestTeamSaveDTO.isCanChange());
            saveTeamDAOBean.exec(teamDAO1);
            return "server update";
        };

        TeamDAO teamDAO = TeamDAO.builder()
                .data(requestTeamSaveDTO.getData())
                .oauthId(requestTeamSaveDTO.getOauthId())
                .canChange(false)
                .build();

        saveTeamDAOBean.exec(teamDAO);

        return "server save";
    }
}
