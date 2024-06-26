package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Repository.PlayerLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePlayerLogDAOBean {

    PlayerLogRepositoryJPA playerLogRepositoryJPA;

    @Autowired
    public SavePlayerLogDAOBean(PlayerLogRepositoryJPA playerLogRepositoryJPA) {
        this.playerLogRepositoryJPA = playerLogRepositoryJPA;
    }

    public void exec(PlayerLog playerLog) {
        playerLogRepositoryJPA.save(playerLog);
    }
}
