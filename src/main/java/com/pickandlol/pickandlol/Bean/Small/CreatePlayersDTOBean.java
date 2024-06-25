package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.PlayerDAO;
import com.pickandlol.pickandlol.Model.ResponsePlayerGetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreatePlayersDTOBean {

    public ResponsePlayerGetDTO exec(PlayerDAO playerDAO){
        return ResponsePlayerGetDTO.builder()
                .playerId(playerDAO.getPlayerId())
                .playerName(playerDAO.getPlayerName())
                .playerImage(playerDAO.getPlayerImage())
                .playerPosition(playerDAO.getPlayerPosition())
                .playerTeam(playerDAO.getPlayerTeam())
                .stat(playerDAO.getStat())
                .kda(playerDAO.getKda())
                .kill(playerDAO.getKill())
                .death(playerDAO.getDeath())
                .assist(playerDAO.getAssist())
                .killRate(playerDAO.getKillRate())
                .playCount(playerDAO.getPlayCount())
                .build();
    }

    public List<ResponsePlayerGetDTO> exec(List<PlayerDAO> playerDAOS){
        return playerDAOS.stream().map(this::exec).toList();
    }
}
