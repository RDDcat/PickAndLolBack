package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchPlayerDAO;
import com.pickandlol.pickandlol.Repository.MatchPlayerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatchPlayersDAOBean {

    MatchPlayerRepositoryJPA matchPlayerRepositoryJPA;

    @Autowired
    public GetMatchPlayersDAOBean(MatchPlayerRepositoryJPA matchPlayerRepositoryJPA){
        this.matchPlayerRepositoryJPA = matchPlayerRepositoryJPA;
    }

    public List<MatchPlayerDAO> exec(Long playerId) {
        return matchPlayerRepositoryJPA.findByPlayerId(playerId);
    }
}
