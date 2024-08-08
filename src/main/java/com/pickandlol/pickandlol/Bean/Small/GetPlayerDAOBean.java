package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import com.pickandlol.pickandlol.Repository.PlayerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPlayerDAOBean {

    PlayerRepositoryJPA playerRepositoryJPA;

    @Autowired
    public GetPlayerDAOBean(PlayerRepositoryJPA playerRepositoryJPA){
        this.playerRepositoryJPA = playerRepositoryJPA;
    }

    public PlayerDAO exec(String playerId){
        return playerRepositoryJPA.findById(playerId).orElse(null);
    }

}
