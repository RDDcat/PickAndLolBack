package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import com.pickandlol.pickandlol.Repository.MatchTeamRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMatchTeamDAOBean {

    MatchTeamRepositoryJPA matchTeamRepositoryJPA;

    @Autowired
    public SaveMatchTeamDAOBean(MatchTeamRepositoryJPA matchTeamRepositoryJPA) {
        this.matchTeamRepositoryJPA = matchTeamRepositoryJPA;
    }

    // 경기 - 팀 정보 저장
    public void exec(MatchTeamDAO matchTeamDAO) {
        matchTeamRepositoryJPA.save(matchTeamDAO);
    }
}
