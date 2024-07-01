package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetTeamsDAOBean;
import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTeamRankBean {

    GetTeamsDAOBean getTeamsDAOBean;

    @Autowired
    public GetTeamRankBean(GetTeamsDAOBean getTeamsDAOBean) {
        this.getTeamsDAOBean = getTeamsDAOBean;
    }

    public List<ResponseTeamGetDTO> exec(){
        List<TeamDAO> teamDAOS = getTeamsDAOBean.exec();

        return teamDAOS.stream()
                .map(teamDAO -> ResponseTeamGetDTO.builder()
                        .data(teamDAO.getData())
                        .oauthId(teamDAO.getOauthId())
                        .build())
                .toList();
    }
}
