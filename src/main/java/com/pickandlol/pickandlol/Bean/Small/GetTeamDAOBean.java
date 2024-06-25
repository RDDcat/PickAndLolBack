package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamsDAO;
import com.pickandlol.pickandlol.Repository.TeamRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTeamDAOBean {

    TeamRepositoryJPA teamRepositoryJPA;

    @Autowired
    public GetTeamDAOBean(TeamRepositoryJPA teamRepositoryJPA) {
        this.teamRepositoryJPA = teamRepositoryJPA;
    }

    public TeamsDAO exec(Long teamId) {
        return teamRepositoryJPA.findById(teamId).orElse(null);
    }
}
