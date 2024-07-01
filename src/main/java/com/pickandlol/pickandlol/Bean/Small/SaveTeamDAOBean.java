package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamDAO;
import com.pickandlol.pickandlol.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveTeamDAOBean {

    TeamRepository teamRepository;

    @Autowired
    public SaveTeamDAOBean(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void exec(TeamDAO teamDAO){
        teamRepository.save(teamDAO);
    }
}
