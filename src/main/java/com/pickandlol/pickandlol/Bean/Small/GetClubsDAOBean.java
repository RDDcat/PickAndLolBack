package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.ClubDAO;
import com.pickandlol.pickandlol.Repository.ClubRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClubsDAOBean {

    ClubRepositoryJPA clubRepositoryJPA;

    @Autowired
    public GetClubsDAOBean(ClubRepositoryJPA clubRepositoryJPA) {
        this.clubRepositoryJPA = clubRepositoryJPA;
    }

    public List<ClubDAO> exec() {
        return clubRepositoryJPA.findAllByOrderByWinCountDescTotalGapDesc();
    }
}
