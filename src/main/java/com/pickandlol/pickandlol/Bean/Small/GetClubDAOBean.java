package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubDAO;
import com.pickandlol.pickandlol.Repository.ClubRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClubDAOBean {

    ClubRepositoryJPA clubRepositoryJPA;

    @Autowired
    public GetClubDAOBean(ClubRepositoryJPA clubRepositoryJPA) {
        this.clubRepositoryJPA = clubRepositoryJPA;
    }

    public ClubDAO exec(Long teamId) {
        return clubRepositoryJPA.findById(teamId).orElse(null);
    }
}
