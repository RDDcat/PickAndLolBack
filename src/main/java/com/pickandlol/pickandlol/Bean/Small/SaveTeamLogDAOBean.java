package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import com.pickandlol.pickandlol.Repository.TeamLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamLogDAOBean {

    TeamLogRepositoryJPA teamLogRepositoryJPA;

    @Autowired
    public SaveTeamLogDAOBean(TeamLogRepositoryJPA teamLogRepositoryJPA) {
        this.teamLogRepositoryJPA = teamLogRepositoryJPA;
    }

    public void exec(TeamLog teamLog){
        teamLogRepositoryJPA.save(teamLog);
    }
}
