package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import com.pickandlol.pickandlol.Repository.PlayerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePlayerDAOBean {

    PlayerRepositoryJPA playerRepositoryJPA;

    @Autowired
    public SavePlayerDAOBean(PlayerRepositoryJPA playerRepositoryJPA){
        this.playerRepositoryJPA = playerRepositoryJPA;
    }

    public void exec(PlayerDAO playerDAO){
        playerRepositoryJPA.save(playerDAO);
    }
}
