package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import com.pickandlol.pickandlol.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTeamsDAOBean {

    TeamRepository teamRepository;

    @Autowired
    public GetTeamsDAOBean(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDAO> exec(){
        return teamRepository.findAll();
    }
}
