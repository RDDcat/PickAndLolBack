package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchPlayerDAO;
import com.pickandlol.pickandlol.Model.RequestMatchPlayerSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateMatchPlayerDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateMatchPlayerDAOBean(CreateUniqueIdBean createUniqueIdBean){
        this.createUniqueIdBean = createUniqueIdBean;
    }

    public MatchPlayerDAO exec(RequestMatchPlayerSaveDTO requestMatchPlayerSaveDTO){
        return MatchPlayerDAO.builder()
                .matchPlayerId(createUniqueIdBean.exec())
                .matchClubId(requestMatchPlayerSaveDTO.getMatchClubId())
                .playerId(requestMatchPlayerSaveDTO.getPlayerId())
                .firstKill(requestMatchPlayerSaveDTO.isFirstKill())
                .firstDeath(requestMatchPlayerSaveDTO.isFirstDeath())
                .mom(requestMatchPlayerSaveDTO.isMom())
                .heraldDriveFail(requestMatchPlayerSaveDTO.getHeraldDriveFail())
                .killCount(requestMatchPlayerSaveDTO.getKillCount())
                .deathCount(requestMatchPlayerSaveDTO.getDeathCount())
                .assistCount(requestMatchPlayerSaveDTO.getAssistCount())
                .soloKills(requestMatchPlayerSaveDTO.isSoloKill())
                .soloDeaths(requestMatchPlayerSaveDTO.isSoloDeaths())
                .createAt(LocalDateTime.now())
                .build();
    }
}
