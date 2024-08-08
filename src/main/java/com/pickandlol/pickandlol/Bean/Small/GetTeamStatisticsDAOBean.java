package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.TeamStatisticDAO;
import com.pickandlol.pickandlol.Repository.TeamStatisticRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTeamStatisticsDAOBean {

    TeamStatisticRepositoryJPA teamStatisticRepositoryJPA;

    @Autowired
    public GetTeamStatisticsDAOBean(TeamStatisticRepositoryJPA teamStatisticRepositoryJPA) {
        this.teamStatisticRepositoryJPA = teamStatisticRepositoryJPA;
    }

    public List<TeamStatisticDAO> exec(){
        return teamStatisticRepositoryJPA.findAll();
    }
}
