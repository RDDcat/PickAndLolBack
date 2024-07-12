package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.RequestTeamLogSaveDTO;
import com.pickandlol.pickandlol.Model.TeamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CreateTeamLogDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateTeamLogDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    public TeamLog exec(RequestTeamLogSaveDTO requestTeamLogSaveDTO){

        // 현재 날짜와 시간 가져오기
        LocalDateTime now = LocalDateTime.now();

        // 원하는 형식 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        // 형식에 맞춰 문자열로 변환
        String formattedDateTime = now.format(formatter);

        return TeamLog.builder()
                .teamLogId(createUniqueIdBean.exec())
                .oauthId(requestTeamLogSaveDTO.getOauthId())
                .topId(requestTeamLogSaveDTO.getTopId())
                .jglId(requestTeamLogSaveDTO.getJglId())
                .midId(requestTeamLogSaveDTO.getMidId())
                .adcId(requestTeamLogSaveDTO.getAdcId())
                .supId(requestTeamLogSaveDTO.getSupId())
                .mvpId(requestTeamLogSaveDTO.getMvpId())
                .createDate(formattedDateTime)
                .build();
    }
}
