package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreatePlayerLogDAOBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetClubLogPlayerStatBean getClubLogPlayerStatBean;

    @Autowired
    public CreatePlayerLogDAOBean(CreateUniqueIdBean createUniqueIdBean, GetClubLogPlayerStatBean getClubLogPlayerStatBean){
        this.createUniqueIdBean = createUniqueIdBean;
        this.getClubLogPlayerStatBean = getClubLogPlayerStatBean;
    }

    public PlayerLog exec(ClubLog clubLog, RequestPlayerLogSaveDTO requestPlayerLogSaveDTO){
        return PlayerLog.builder()
                .playerLogId(createUniqueIdBean.exec())
                .clubLogId(requestPlayerLogSaveDTO.getClubLogId())
                .playerId(requestPlayerLogSaveDTO.getPlayerId())
                .stat(getClubLogPlayerStatBean.exec(clubLog, requestPlayerLogSaveDTO))
                .firstKill(requestPlayerLogSaveDTO.isFirstKill())
                .firstDeath(requestPlayerLogSaveDTO.isFirstDeath())
                .mom(requestPlayerLogSaveDTO.isMom())
                .heraldDriveFail(requestPlayerLogSaveDTO.getHeraldDriveFail())
                .killCount(requestPlayerLogSaveDTO.getKillCount())
                .deathCount(requestPlayerLogSaveDTO.getDeathCount())
                .assistCount(requestPlayerLogSaveDTO.getAssistCount())
                .soloKills(requestPlayerLogSaveDTO.getSoloKills())
                .soloDeaths(requestPlayerLogSaveDTO.getSoloDeaths())
                .createAt(LocalDateTime.now())
                .build();
    }
}
