package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.TeamStatisticDAO;
import com.pickandlol.pickandlol.Repository.TeamStatisticRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTeamStatisticDAOBean {

    TeamStatisticRepositoryJPA teamStatisticRepositoryJPA;

    @Autowired
    public GetTeamStatisticDAOBean(TeamStatisticRepositoryJPA teamStatisticRepositoryJPA) {
        this.teamStatisticRepositoryJPA = teamStatisticRepositoryJPA;
    }

    public TeamStatisticDAO exec(Long userId, Week week){
        return teamStatisticRepositoryJPA.findByUserIdAndWeek(userId, week);
    }
}
