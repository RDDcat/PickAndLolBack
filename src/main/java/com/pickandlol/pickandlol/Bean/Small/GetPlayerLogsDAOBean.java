package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Repository.PlayerLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPlayerLogsDAOBean {

    PlayerLogRepositoryJPA playerLogRepositoryJPA;

    @Autowired
    public GetPlayerLogsDAOBean(PlayerLogRepositoryJPA playerLogRepositoryJPA){
        this.playerLogRepositoryJPA = playerLogRepositoryJPA;
    }

    public List<PlayerLog> exec(Long playerId) {
        return playerLogRepositoryJPA.findByPlayerId(playerId);
    }

    public List<PlayerLog> exec(Long playerId, Week week) {

        return playerLogRepositoryJPA.findByPlayerIdAndWeek(playerId, week);
    }
}
