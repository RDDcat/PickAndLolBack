package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamStatisticDAO;
import com.pickandlol.pickandlol.Repository.TeamStatisticRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamStatisticDAOBean {

    TeamStatisticRepositoryJPA teamStatisticRepositoryJPA;

    @Autowired
    public SaveTeamStatisticDAOBean(TeamStatisticRepositoryJPA teamStatisticRepositoryJPA){
        this.teamStatisticRepositoryJPA = teamStatisticRepositoryJPA;
    }

    public void exec(TeamStatisticDAO teamStatisticDAO){
        teamStatisticRepositoryJPA.save(teamStatisticDAO);
    }
}
