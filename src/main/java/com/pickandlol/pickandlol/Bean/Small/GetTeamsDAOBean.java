package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamsDAO;
import com.pickandlol.pickandlol.Repository.TeamRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTeamsDAOBean {

    TeamRepositoryJPA teamRepositoryJPA;

    @Autowired
    public GetTeamsDAOBean(TeamRepositoryJPA teamRepositoryJPA) {
        this.teamRepositoryJPA = teamRepositoryJPA;
    }

    public List<TeamsDAO> exec() {
        return teamRepositoryJPA.findAllByOrderByWinCountDescTotalGapDesc();
    }
}
