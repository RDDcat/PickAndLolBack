package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import com.pickandlol.pickandlol.Others.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CreatePlayerLogDAOBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetClubLogPlayerStatBean getClubLogPlayerStatBean;
    GetWeekEnum getWeekEnum;
    TimeFormatter timeFormatter;

    @Autowired
    public CreatePlayerLogDAOBean(CreateUniqueIdBean createUniqueIdBean, GetClubLogPlayerStatBean getClubLogPlayerStatBean, GetWeekEnum getWeekEnum, TimeFormatter timeFormatter){
        this.createUniqueIdBean = createUniqueIdBean;
        this.getClubLogPlayerStatBean = getClubLogPlayerStatBean;
        this.getWeekEnum = getWeekEnum;
        this.timeFormatter = timeFormatter;
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


        LocalDateTime createDate = timeFormatter.exec(date);

        Week week = getWeekEnum.exec(createDate);

        return PlayerLog.builder()
                .playerLogId(createUniqueIdBean.exec())
                .clubLogId(requestPlayerLogSaveDTO.getClubLogId())
                .playerId(requestPlayerLogSaveDTO.getPlayerId())
                .stat(getClubLogPlayerStatBean.exec(clubLog, requestPlayerLogSaveDTO))
                .isFirstKill(requestPlayerLogSaveDTO.isFirstKill())
                .isFirstDeath(requestPlayerLogSaveDTO.isFirstDeath())
                .isPog(requestPlayerLogSaveDTO.isPog())
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
