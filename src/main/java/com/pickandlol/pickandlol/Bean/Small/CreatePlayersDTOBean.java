package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.PlayerDAO;
import com.pickandlol.pickandlol.Model.ResponsePlayerGetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreatePlayersDTOBean {

    public ResponsePlayerGetDTO exec(PlayerDAO playerDAO){

        // 총 분 계산 (소수점 반영)
        double totalMinutes = playerDAO.getPlayTime() / 60.0;

        // 분당 데미지 및 CS 계산
        double damagePerMinute = playerDAO.getDamage() / totalMinutes;
        double csPerMinute = playerDAO.getCs() / totalMinutes;

        damagePerMinute = Math.round(damagePerMinute * 10) / 10.0;
        csPerMinute = Math.round(csPerMinute * 10) / 10.0;

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
                .cs(csPerMinute)
                .damage(damagePerMinute)
                .build();
    }

    public List<ResponsePlayerGetDTO> exec(List<PlayerDAO> playerDAOS){
        return playerDAOS.stream().map(this::exec).toList();
    }
}
