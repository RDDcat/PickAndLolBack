package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Repository.MatchRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatchsByWinnerClubIdDAOBean {

    MatchRepositoryJPA matchRepositoryJPA;

    @Autowired
    public GetMatchsByWinnerClubIdDAOBean(MatchRepositoryJPA matchRepositoryJPA){
        this.matchRepositoryJPA = matchRepositoryJPA;
    }

    public List<MatchDAO> exec(Long clubId) {
        return matchRepositoryJPA.findByWinnerClubId(clubId);
    }
}
