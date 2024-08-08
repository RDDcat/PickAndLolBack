package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.ClubLog;
import com.pickandlol.pickandlol.Repository.ClubLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClubLogsByMatchIdDAOBean {

    ClubLogRepositoryJPA clubLogRepositoryJPA;

    @Autowired
    public GetClubLogsByMatchIdDAOBean(ClubLogRepositoryJPA clubLogRepositoryJPA) {
        this.clubLogRepositoryJPA = clubLogRepositoryJPA;
    }

    public List<ClubLog> exec(String matchId) {
        return clubLogRepositoryJPA.findAllByMatchId(matchId);
    }
}
