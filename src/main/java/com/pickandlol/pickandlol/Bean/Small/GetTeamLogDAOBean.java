package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import com.pickandlol.pickandlol.Repository.TeamLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTeamLogDAOBean {

    TeamLogRepositoryJPA teamLogRepositoryJPA;

    @Autowired
    public GetTeamLogDAOBean(TeamLogRepositoryJPA teamLogRepositoryJPA) {
        this.teamLogRepositoryJPA = teamLogRepositoryJPA;
    }

    public TeamLog exec(String oauthId){
        return teamLogRepositoryJPA.findTopByOauthIdOrderByCreateDateDesc(oauthId);
    }
}
