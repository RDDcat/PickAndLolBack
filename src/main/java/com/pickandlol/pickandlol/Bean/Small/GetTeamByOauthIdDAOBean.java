package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.TeamDAO;
import com.pickandlol.pickandlol.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTeamByOauthIdDAOBean {

    TeamRepository teamRepository;

    @Autowired
    public GetTeamByOauthIdDAOBean(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDAO exec(String oauthId){
        return teamRepository.findByOauthId(oauthId);
    }
}
