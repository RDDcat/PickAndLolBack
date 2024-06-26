package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePlayerLogDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreatePlayerLogDAOBean(CreateUniqueIdBean createUniqueIdBean){
        this.createUniqueIdBean = createUniqueIdBean;
    }

    public PlayerLog exec(RequestPlayerLogSaveDTO requestPlayerLogSaveDTO){
        return PlayerLog.builder()
                .playerLogId(createUniqueIdBean.exec())
                .clubLogId(requestPlayerLogSaveDTO.getClubLogId())
                .playerId(requestPlayerLogSaveDTO.getPlayerId())
                .firstKill(requestPlayerLogSaveDTO.isFirstKill())
                .firstDeath(requestPlayerLogSaveDTO.isFirstDeath())
                .mom(requestPlayerLogSaveDTO.isMom())
                .heraldDriveFail(requestPlayerLogSaveDTO.getHeraldDriveFail())
                .killCount(requestPlayerLogSaveDTO.getKillCount())
                .deathCount(requestPlayerLogSaveDTO.getDeathCount())
                .assistCount(requestPlayerLogSaveDTO.getAssistCount())
                .soloKills(requestPlayerLogSaveDTO.isSoloKill())
                .soloDeaths(requestPlayerLogSaveDTO.isSoloDeaths())
                .createAt(LocalDateTime.now())
                .build();
    }
}
