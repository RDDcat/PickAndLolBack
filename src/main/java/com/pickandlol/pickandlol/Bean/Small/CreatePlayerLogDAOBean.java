package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CreatePlayerLogDAOBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetClubLogPlayerStatBean getClubLogPlayerStatBean;
    GetWeekEnum getWeekEnum;

    @Autowired
    public CreatePlayerLogDAOBean(CreateUniqueIdBean createUniqueIdBean, GetClubLogPlayerStatBean getClubLogPlayerStatBean, GetWeekEnum getWeekEnum){
        this.createUniqueIdBean = createUniqueIdBean;
        this.getClubLogPlayerStatBean = getClubLogPlayerStatBean;
        this.getWeekEnum = getWeekEnum;
    }

    public PlayerLog exec(ClubLog clubLog, RequestPlayerLogSaveDTO requestPlayerLogSaveDTO, MatchDAO matchDAO){

        String playTime = clubLog.getPlayTime();

        // 분과 초를 분리
        String[] parts = playTime.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);

        // 총 초 계산
        int totalSeconds = (minutes * 60) + seconds;

        Integer year = matchDAO.getYear();
        Integer month = matchDAO.getMonth();
        Integer day = matchDAO.getDay();
        String[] time = matchDAO.getTime().split(":");
        String formattedMonth = String.format("%02d", month);
        String formattedDay = String.format("%02d", day);

        String date = year + formattedMonth+ formattedDay + time[0] + time[1];

        // 시작 기준 날짜 설정
        LocalDateTime startReferenceDate = LocalDateTime.of(2024, 6, 9, 19, 0);

        // 날짜 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        LocalDateTime createDate = LocalDateTime.parse(date, formatter);

        Week week = getWeekEnum.exec(startReferenceDate, createDate);

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
                .damage(requestPlayerLogSaveDTO.getDamage())
                .cs(requestPlayerLogSaveDTO.getCs())
                .playTime(totalSeconds)
                .date(date)
                .week(week)
                .createAt(LocalDateTime.now())
                .build();
    }
}
