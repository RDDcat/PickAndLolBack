package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubDAO;
import com.pickandlol.pickandlol.Repository.ClubRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveClubDAOBean {

    ClubRepositoryJPA clubRepositoryJPA;

    @Autowired
    public SaveClubDAOBean(ClubRepositoryJPA clubRepositoryJPA) {
        this.clubRepositoryJPA = clubRepositoryJPA;
    }

    public void exec(ClubDAO clubDAO) {
        clubRepositoryJPA.save(clubDAO);
    }
}
