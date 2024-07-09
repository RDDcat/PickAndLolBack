package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateTeamStatisticDTOBean;
import com.pickandlol.pickandlol.Bean.Small.GetPlayerLogsDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetTeamLogsDAOBean;
import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.PlayerLog;
import com.pickandlol.pickandlol.Model.TeamLog;
import com.pickandlol.pickandlol.Model.TeamStatisticDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SaveTeamStatisticBean {

    GetTeamLogsDAOBean getTeamLogsDAOBean;
    GetPlayerLogsDAOBean getPlayerLogsDAOBean;
    CreateTeamStatisticDTOBean createTeamStatisticDTOBean;

    @Autowired
    public SaveTeamStatisticBean(GetTeamLogsDAOBean getTeamLogsDAOBean, GetPlayerLogsDAOBean getPlayerLogsDAOBean, CreateTeamStatisticDTOBean createTeamStatisticDTOBean){
        this.getTeamLogsDAOBean = getTeamLogsDAOBean;
        this.getPlayerLogsDAOBean = getPlayerLogsDAOBean;
        this.createTeamStatisticDTOBean = createTeamStatisticDTOBean;
    }

    public void exec(){

        // 팀 로그 전체 가져오기
        List<TeamLog> teamLogs = getTeamLogsDAOBean.exec();

        // 시작 기준 날짜 설정
        LocalDateTime startReferenceDate = LocalDateTime.of(2024, 6, 9, 19, 0);

        // 날짜 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        // 결과를 저장할 Map
        Map<String, Map<String, Map<String, Integer>>> resultMap = new HashMap<>();

        // 반복문 돌려서 전체 다 돌려
        for (TeamLog teamLog : teamLogs){

            // Map<String, Map<String, <Map<String, Integer>>>
            // 가장 바깥쪽부터 key는 userId, value는 Map<String, Map<String, Integer>>
            // 유저 아이디는 겹칠 수 있음

            // 그 다음 key는 week, value는 Map<String, Integer>
            // 그 다음 key는 position 및 total, value는 Integer

            LocalDateTime createDate = LocalDateTime.parse(teamLog.getCreateDate(), formatter);

            // 주차 계산
            int weekNumber = calculateWeekNumber(startReferenceDate, createDate);

            // 주차를 Week enum 타입으로 변환
            Week week = getWeekEnum(weekNumber);
            String weekEnum = week.name();

            // 유저 ID
            String oauthId = teamLog.getOauthId().toString();

            List<PlayerLog> topPlayers = getPlayerLogsDAOBean.exec(teamLog.getTopId(), week);
            List<PlayerLog> jglPlayers = getPlayerLogsDAOBean.exec(teamLog.getJglId(), week);
            List<PlayerLog> midPlayers = getPlayerLogsDAOBean.exec(teamLog.getMidId(), week);
            List<PlayerLog> adcPlayers = getPlayerLogsDAOBean.exec(teamLog.getAdcId(), week);
            List<PlayerLog> supPlayers = getPlayerLogsDAOBean.exec(teamLog.getSupId(), week);

            int total=0;

            // 탑선수 playerLog.getStat()를 통한 누적 구하기
            for (PlayerLog playerLog : topPlayers){
                LocalDateTime playerLogDate = LocalDateTime.parse(playerLog.getDate(), formatter);

                if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                    total += playerLog.getStat();
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("top", playerLog.getStat(), Integer::sum);
                }
                else if (teamLog.getUpdateDate() != null){
                    LocalDateTime updateAt = LocalDateTime.parse(teamLog.getUpdateDate(), formatter);
                    if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                        total += playerLog.getStat();
                        // 결과 맵에 데이터 추가
                        resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                                .computeIfAbsent(weekEnum, k -> new HashMap<>())
                                .merge("top", playerLog.getStat(), Integer::sum);
                    }
                }
            }

            // 정글선수 stat 누적 구하기
            for (PlayerLog playerLog : jglPlayers){
                LocalDateTime playerLogDate = LocalDateTime.parse(playerLog.getDate(), formatter);

                if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                    total += playerLog.getStat();
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("jgl", playerLog.getStat(), Integer::sum);
                }
                else if (teamLog.getUpdateDate() != null){
                    LocalDateTime updateAt = LocalDateTime.parse(teamLog.getUpdateDate(), formatter);
                    if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                        total += playerLog.getStat();
                        // 결과 맵에 데이터 추가
                        resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                                .computeIfAbsent(weekEnum, k -> new HashMap<>())
                                .merge("jgl", playerLog.getStat(), Integer::sum);
                    }
                }
            }

            // 미드선수 stat 누적 구하기
            for (PlayerLog playerLog : midPlayers){
                LocalDateTime playerLogDate = LocalDateTime.parse(playerLog.getDate(), formatter);

                if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                    total += playerLog.getStat();
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("mid", playerLog.getStat(), Integer::sum);
                }
                else if (teamLog.getUpdateDate() != null){
                    LocalDateTime updateAt = LocalDateTime.parse(teamLog.getUpdateDate(), formatter);
                    if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                        total += playerLog.getStat();
                        // 결과 맵에 데이터 추가
                        resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                                .computeIfAbsent(weekEnum, k -> new HashMap<>())
                                .merge("mid", playerLog.getStat(), Integer::sum);
                    }
                }
            }

            // 원딜선수 stat 누적 구하기
            for (PlayerLog playerLog : adcPlayers){
                LocalDateTime playerLogDate = LocalDateTime.parse(playerLog.getDate(), formatter);

                if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                    total += playerLog.getStat();
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("adc", playerLog.getStat(), Integer::sum);
                }
                else if (teamLog.getUpdateDate() != null){
                    LocalDateTime updateAt = LocalDateTime.parse(teamLog.getUpdateDate(), formatter);
                    if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                        total += playerLog.getStat();
                        // 결과 맵에 데이터 추가
                        resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                                .computeIfAbsent(weekEnum, k -> new HashMap<>())
                                .merge("adc", playerLog.getStat(), Integer::sum);
                    }
                }
            }

            // 서폿선수 stat 누적 구하기
            for (PlayerLog playerLog : supPlayers){
                LocalDateTime playerLogDate = LocalDateTime.parse(playerLog.getDate(), formatter);

                if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                    total += playerLog.getStat();
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("sup", playerLog.getStat(), Integer::sum);
                }
                else if (teamLog.getUpdateDate() != null){
                    LocalDateTime updateAt = LocalDateTime.parse(teamLog.getUpdateDate(), formatter);
                    if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                        total += playerLog.getStat();
                        // 결과 맵에 데이터 추가
                        resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                                .computeIfAbsent(weekEnum, k -> new HashMap<>())
                                .merge("sup", playerLog.getStat(), Integer::sum);
                    }
                }
            }

            // 팀 전체 stat 누적 구하기
            resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                    .computeIfAbsent(weekEnum, k -> new HashMap<>())
                    .merge("total", total, Integer::sum);

            createTeamStatisticDTOBean.exec(resultMap);
        }

    }

    // 주차를 계산하는 메서드
    private static int calculateWeekNumber(LocalDateTime startReferenceDate, LocalDateTime createDate) {
        LocalDateTime tempDate = startReferenceDate;
        int weekNumber = 1;

        while (!createDate.isBefore(tempDate.plusWeeks(1))) {
            tempDate = tempDate.plusWeeks(1);
            weekNumber++;
        }

        return weekNumber;
    }

    // 주차를 Week enum 타입으로 변환하는 메서드
    private static Week getWeekEnum(int weekNumber) {
        switch (weekNumber) {
            case 1: return Week.WEEK1;
            case 2: return Week.WEEK2;
            case 3: return Week.WEEK3;
            case 4: return Week.WEEK4;
            case 5: return Week.WEEK5;
            case 6: return Week.WEEK6;
            case 7: return Week.WEEK7;
            case 8: return Week.WEEK8;
            case 9: return Week.WEEK9;
            case 10: return Week.WEEK10;
            default: throw new IllegalArgumentException("Invalid week number: " + weekNumber);
        }
    }
}
