package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamsDAO;
import com.pickandlol.pickandlol.Repository.TeamRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamDAOBean {

    TeamRepositoryJPA teamRepositoryJPA;

    @Autowired
    public SaveTeamDAOBean(TeamRepositoryJPA teamRepositoryJPA) {
        this.teamRepositoryJPA = teamRepositoryJPA;
    }

    public void exec(TeamsDAO teamsDAO) {
        teamRepositoryJPA.save(teamsDAO);
    }
}
