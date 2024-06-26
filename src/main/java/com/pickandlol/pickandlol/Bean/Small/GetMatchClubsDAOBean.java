package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchClubDAO;
import com.pickandlol.pickandlol.Repository.MatchClubRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatchClubsDAOBean {

    MatchClubRepositoryJPA matchClubRepositoryJPA;

    @Autowired
    public GetMatchClubsDAOBean(MatchClubRepositoryJPA matchClubRepositoryJPA) {
        this.matchClubRepositoryJPA = matchClubRepositoryJPA;
    }

    public List<MatchClubDAO> exec(Long teamId) {
        return matchClubRepositoryJPA.findAllByTeamId(teamId);
    }

}
