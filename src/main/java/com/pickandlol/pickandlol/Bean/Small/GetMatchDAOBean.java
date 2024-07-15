package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Repository.MatchRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMatchDAOBean {

    MatchRepositoryJPA matchRepositoryJPA;

    @Autowired
    public GetMatchDAOBean(MatchRepositoryJPA matchRepositoryJPA) {
        this.matchRepositoryJPA = matchRepositoryJPA;
    }

    public MatchDAO exec(String matchId) {
        return matchRepositoryJPA.findById(matchId).orElse(null);
    }
}
