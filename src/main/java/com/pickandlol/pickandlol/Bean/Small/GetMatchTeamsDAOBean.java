package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import com.pickandlol.pickandlol.Repository.MatchTeamRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatchTeamsDAOBean {

    MatchTeamRepositoryJPA matchTeamRepositoryJPA;

    @Autowired
    public GetMatchTeamsDAOBean(MatchTeamRepositoryJPA matchTeamRepositoryJPA) {
        this.matchTeamRepositoryJPA = matchTeamRepositoryJPA;
    }

    public List<MatchTeamDAO> exec(Long teamId) {
        return matchTeamRepositoryJPA.findAllByTeamId(teamId);
    }

}
