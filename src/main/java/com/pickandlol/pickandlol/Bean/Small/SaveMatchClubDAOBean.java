package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchClubDAO;
import com.pickandlol.pickandlol.Repository.MatchClubRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMatchClubDAOBean {

    MatchClubRepositoryJPA matchClubRepositoryJPA;

    @Autowired
    public SaveMatchClubDAOBean(MatchClubRepositoryJPA matchClubRepositoryJPA) {
        this.matchClubRepositoryJPA = matchClubRepositoryJPA;
    }

    // 경기 - 팀 정보 저장
    public void exec(MatchClubDAO matchClubDAO) {
        matchClubRepositoryJPA.save(matchClubDAO);
    }
}
