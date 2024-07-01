package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Repository.ClubLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClubLogDAOBean {

    ClubLogRepositoryJPA clubLogRepositoryJPA;

    @Autowired
    public GetClubLogDAOBean(ClubLogRepositoryJPA clubLogRepositoryJPA){
        this.clubLogRepositoryJPA = clubLogRepositoryJPA;
    }

    public ClubLog exec(Long clubLogId){
        return clubLogRepositoryJPA.findById(clubLogId).orElse(null);
    }
}
