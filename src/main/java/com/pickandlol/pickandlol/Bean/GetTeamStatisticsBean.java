package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetTeamStatisticsDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetWeekEnum;
import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.ResponseTeamStatisticGetDTO;
import com.pickandlol.pickandlol.Model.TeamStatisticDAO;
import com.pickandlol.pickandlol.Others.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetTeamStatisticsBean {

    TimeFormatter timeFormatter;
    GetWeekEnum getWeekEnum;
    GetTeamStatisticsDAOBean getTeamStatisticsDAOBean;

    @Autowired
    public GetTeamStatisticsBean(TimeFormatter timeFormatter, GetWeekEnum getWeekEnum, GetTeamStatisticsDAOBean getTeamStatisticsDAOBean){
        this.timeFormatter = timeFormatter;
        this.getWeekEnum = getWeekEnum;
        this.getTeamStatisticsDAOBean = getTeamStatisticsDAOBean;
    }

    // 팀 통계 전체 조회
    public List<ResponseTeamStatisticGetDTO> exec(){

        // 오늘 날짜 기반으로 몇 주차인지 판단
        // 주차를 Week enum 타입으로 변환
        Week week = getWeekEnum.exec(LocalDateTime.now());

        // 팀 통계 전체 가져오기
        List<TeamStatisticDAO> teamStatisticDAOList = getTeamStatisticsDAOBean.exec();

        // week 가 다르더라도 userId가 겹치는 것 끼리 score 합산
        // 만약 week가 일치한다면 다른곳에 해당 내용만 추가로 저장
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> weekMap = new HashMap<>();
        for (TeamStatisticDAO teamStatisticDAO : teamStatisticDAOList) {
            map.merge(teamStatisticDAO.getOauthId(), teamStatisticDAO.getScore(), Integer::sum);
            if (teamStatisticDAO.getWeek() == week) {
                weekMap.put(teamStatisticDAO.getOauthId(), teamStatisticDAO.getScore());
            }
        }

        // 합산된 데이터를 저장
        List<ResponseTeamStatisticGetDTO> responseTeamStatisticGetDTOList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            responseTeamStatisticGetDTOList.add(ResponseTeamStatisticGetDTO.builder()
                    .oauthId(entry.getKey())
                    .weekStat(weekMap.get(entry.getKey()))
                    .totalStat(entry.getValue())
                    .build());
        }

        // 최종 결과 반환
        return responseTeamStatisticGetDTOList;
    }
}
