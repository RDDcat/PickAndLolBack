package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchPlayerDAO;
import com.pickandlol.pickandlol.Repository.MatchPlayerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMatchPlayerDAOBean {

    MatchPlayerRepositoryJPA matchPlayerRepositoryJPA;

    @Autowired
    public SaveMatchPlayerDAOBean(MatchPlayerRepositoryJPA matchPlayerRepositoryJPA) {
        this.matchPlayerRepositoryJPA = matchPlayerRepositoryJPA;
    }

    public void exec(MatchPlayerDAO matchPlayerDAO) {
        matchPlayerRepositoryJPA.save(matchPlayerDAO);
    }
}
