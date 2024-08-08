package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.ClubLog;
import com.pickandlol.pickandlol.Repository.ClubLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClubLogsDAOBean {

    ClubLogRepositoryJPA clubLogRepositoryJPA;

    @Autowired
    public GetClubLogsDAOBean(ClubLogRepositoryJPA clubLogRepositoryJPA) {
        this.clubLogRepositoryJPA = clubLogRepositoryJPA;
    }

    public List<ClubLog> exec(String clubId) {
        return clubLogRepositoryJPA.findAllByClubId(clubId);
    }

}
