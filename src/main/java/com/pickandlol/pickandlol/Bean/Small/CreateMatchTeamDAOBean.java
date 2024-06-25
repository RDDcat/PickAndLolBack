package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import com.pickandlol.pickandlol.Model.RequestMatchTeamSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CreateMatchTeamDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateMatchTeamDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 경기 - 팀 정보 저장
    public MatchTeamDAO exec(RequestMatchTeamSaveDTO requestMatchTeamSaveDTO) {

        return MatchTeamDAO.builder()
                .matchTeamId(createUniqueIdBean.exec())
                .matchType(requestMatchTeamSaveDTO.getMatchType())
                .matchResult(requestMatchTeamSaveDTO.getMatchResult())
                .playTime(requestMatchTeamSaveDTO.getPlayTime())
                .voidGrubs(requestMatchTeamSaveDTO.getVoidGrubs())
                .heralds(requestMatchTeamSaveDTO.getHeralds())
                .drakes(requestMatchTeamSaveDTO.getDrakes())
                .elders(requestMatchTeamSaveDTO.getElders())
                .barons(requestMatchTeamSaveDTO.getBarons())
                .teamId(requestMatchTeamSaveDTO.getTeamId())
                .topId(requestMatchTeamSaveDTO.getTopId())
                .jungleId(requestMatchTeamSaveDTO.getJungleId())
                .midId(requestMatchTeamSaveDTO.getMidId())
                .adcId(requestMatchTeamSaveDTO.getAdcId())
                .supportId(requestMatchTeamSaveDTO.getSupportId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
