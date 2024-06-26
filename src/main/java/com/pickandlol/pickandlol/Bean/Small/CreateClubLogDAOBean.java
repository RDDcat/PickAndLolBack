package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.RequestClubLogSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateClubLogDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateClubLogDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 경기 - 팀 정보 저장
    public ClubLog exec(RequestClubLogSaveDTO requestClubLogSaveDTO) {

        return ClubLog.builder()
                .matchTeamId(createUniqueIdBean.exec())
                .matchType(requestClubLogSaveDTO.getMatchType())
                .matchResult(requestClubLogSaveDTO.getMatchResult())
                .playTime(requestClubLogSaveDTO.getPlayTime())
                .voidGrubs(requestClubLogSaveDTO.getVoidGrubs())
                .heralds(requestClubLogSaveDTO.getHeralds())
                .drakes(requestClubLogSaveDTO.getDrakes())
                .elders(requestClubLogSaveDTO.getElders())
                .barons(requestClubLogSaveDTO.getBarons())
                .killCount(requestClubLogSaveDTO.getKillCount())
                .deathCount(requestClubLogSaveDTO.getDeathCount())
                .assistCount(requestClubLogSaveDTO.getAssistCount())
                .teamId(requestClubLogSaveDTO.getTeamId())
                .topId(requestClubLogSaveDTO.getTopId())
                .jungleId(requestClubLogSaveDTO.getJungleId())
                .midId(requestClubLogSaveDTO.getMidId())
                .adcId(requestClubLogSaveDTO.getAdcId())
                .supportId(requestClubLogSaveDTO.getSupportId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
