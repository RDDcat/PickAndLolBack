package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamLog;
import com.pickandlol.pickandlol.Repository.TeamLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTeamLogsDAOBean {

    TeamLogRepositoryJPA teamLogRepositoryJPA;

    @Autowired
    public GetTeamLogsDAOBean(TeamLogRepositoryJPA teamLogRepositoryJPA) {
        this.teamLogRepositoryJPA = teamLogRepositoryJPA;
    }

    public List<TeamLog> exec(){
        return teamLogRepositoryJPA.findAll();
    }
}
