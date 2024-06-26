package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchClubDAO;
import com.pickandlol.pickandlol.Model.RequestMatchClubSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateMatchClubDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateMatchClubDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 경기 - 팀 정보 저장
    public MatchClubDAO exec(RequestMatchClubSaveDTO requestMatchClubSaveDTO) {

        return MatchClubDAO.builder()
                .matchTeamId(createUniqueIdBean.exec())
                .matchType(requestMatchClubSaveDTO.getMatchType())
                .matchResult(requestMatchClubSaveDTO.getMatchResult())
                .playTime(requestMatchClubSaveDTO.getPlayTime())
                .voidGrubs(requestMatchClubSaveDTO.getVoidGrubs())
                .heralds(requestMatchClubSaveDTO.getHeralds())
                .drakes(requestMatchClubSaveDTO.getDrakes())
                .elders(requestMatchClubSaveDTO.getElders())
                .barons(requestMatchClubSaveDTO.getBarons())
                .killCount(requestMatchClubSaveDTO.getKillCount())
                .deathCount(requestMatchClubSaveDTO.getDeathCount())
                .assistCount(requestMatchClubSaveDTO.getAssistCount())
                .teamId(requestMatchClubSaveDTO.getTeamId())
                .topId(requestMatchClubSaveDTO.getTopId())
                .jungleId(requestMatchClubSaveDTO.getJungleId())
                .midId(requestMatchClubSaveDTO.getMidId())
                .adcId(requestMatchClubSaveDTO.getAdcId())
                .supportId(requestMatchClubSaveDTO.getSupportId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
