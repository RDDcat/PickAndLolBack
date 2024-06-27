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
                .clubId(playerDAO.getClubId())
                .stat(playerDAO.getStat())
                .kda(playerDAO.getKda())
                .killCount(playerDAO.getKillCount())
                .deathCount(playerDAO.getDeathCount())
                .assistCount(playerDAO.getAssistCount())
                .killRate(playerDAO.getKillRate())
                .playCount(playerDAO.getPlayCount())
                .build();
    }

    public List<ResponsePlayerGetDTO> exec(List<PlayerDAO> playerDAOS){
        return playerDAOS.stream().map(this::exec).toList();
    }
}
