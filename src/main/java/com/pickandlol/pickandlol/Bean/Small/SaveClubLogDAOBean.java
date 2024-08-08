package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.ClubLog;
import com.pickandlol.pickandlol.Repository.ClubLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveClubLogDAOBean {

    ClubLogRepositoryJPA clubLogRepositoryJPA;

    @Autowired
    public SaveClubLogDAOBean(ClubLogRepositoryJPA clubLogRepositoryJPA) {
        this.clubLogRepositoryJPA = clubLogRepositoryJPA;
    }

    // 경기 - 팀 정보 저장
    public void exec(ClubLog clubLog) {
        clubLogRepositoryJPA.save(clubLog);
    }
}
