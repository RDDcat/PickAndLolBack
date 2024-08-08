package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetTeamByOauthIdDAOBean;
import com.pickandlol.pickandlol.Model.DTO.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTeamBean {

    GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean;

    @Autowired
    public GetTeamBean(GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean) {
        this.getTeamByOauthIdDAOBean = getTeamByOauthIdDAOBean;
    }

    public ResponseTeamGetDTO exec(String oauthId){

        TeamDAO teamDAO = getTeamByOauthIdDAOBean.exec(oauthId);
        if (teamDAO == null) return null;

        return ResponseTeamGetDTO.builder()
                .data(teamDAO.getData())
                .oauthId(teamDAO.getOauthId())
                .canChange(teamDAO.isCanChange())
                .build();
    }
}
