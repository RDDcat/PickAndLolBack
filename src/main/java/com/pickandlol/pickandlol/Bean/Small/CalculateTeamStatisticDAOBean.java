package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.DAO.PlayerLog;
import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import com.pickandlol.pickandlol.Others.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CalculateTeamStatisticDAOBean {

    TimeFormatter timeFormatter;
    GetWeekEnum getWeekEnum;
    GetPlayerLogsDAOBean getPlayerLogsDAOBean;

    @Autowired
    public CalculateTeamStatisticDAOBean(TimeFormatter timeFormatter, GetWeekEnum getWeekEnum, GetPlayerLogsDAOBean getPlayerLogsDAOBean){
        this.timeFormatter = timeFormatter;
        this.getWeekEnum = getWeekEnum;
        this.getPlayerLogsDAOBean = getPlayerLogsDAOBean;
    }

    public Map<String, Map<String, Map<String, Integer>>> exec(TeamLog teamLog, Map<String, Map<String, Map<String, Integer>>> resultMap){

        // Map<String, Map<String, <Map<String, Integer>>>
        // 가장 바깥쪽부터 key는 userId, value는 Map<String, Map<String, Integer>>
        // 유저 아이디는 겹칠 수 있음

        // 그 다음 key는 week, value는 Map<String, Integer>
        // 그 다음 key는 position 및 total, value는 Integer

        LocalDateTime createDate = timeFormatter.exec(teamLog.getCreateDate());

        // 주차를 Week enum 타입으로 변환
        Week week = getWeekEnum.exec(createDate);
        String weekEnum = week.name();


        // 유저 ID
        String oauthId = teamLog.getOauthId();

        List<PlayerLog> topPlayers = getPlayerLogsDAOBean.exec(teamLog.getTopId(), week);
        List<PlayerLog> jglPlayers = getPlayerLogsDAOBean.exec(teamLog.getJglId(), week);
        List<PlayerLog> midPlayers = getPlayerLogsDAOBean.exec(teamLog.getMidId(), week);
        List<PlayerLog> adcPlayers = getPlayerLogsDAOBean.exec(teamLog.getAdcId(), week);
        List<PlayerLog> supPlayers = getPlayerLogsDAOBean.exec(teamLog.getSupId(), week);
        int total=0;

        boolean flag = teamLog.getTopId().equals(teamLog.getMvpId());
        // 탑선수 playerLog.getStat()를 통한 누적 구하기
        for (PlayerLog playerLog : topPlayers){
            LocalDateTime playerLogDate = timeFormatter.exec(playerLog.getDate());

            if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                total += playerLog.getStat();
                if (flag){
                    total += playerLog.getStat();
                }
                // 결과 맵에 데이터 추가
                resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                        .computeIfAbsent(weekEnum, k -> new HashMap<>())
                        .merge("top", playerLog.getStat(), Integer::sum);
            }
            else if (teamLog.getUpdateDate() != null){
                LocalDateTime updateAt = timeFormatter.exec(teamLog.getUpdateDate());
                if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                    total += playerLog.getStat();
                    if (flag){
                        total += playerLog.getStat();
                    }
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("top", playerLog.getStat(), Integer::sum);
                }
            }
        }
        flag = teamLog.getJglId().equals(teamLog.getMvpId());
        // 정글선수 stat 누적 구하기
        for (PlayerLog playerLog : jglPlayers){
            LocalDateTime playerLogDate = timeFormatter.exec(playerLog.getDate());

            if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                total += playerLog.getStat();
                if (flag){
                    total += playerLog.getStat();
                }
                // 결과 맵에 데이터 추가
                resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                        .computeIfAbsent(weekEnum, k -> new HashMap<>())
                        .merge("jgl", playerLog.getStat(), Integer::sum);
            }
            else if (teamLog.getUpdateDate() != null){
                LocalDateTime updateAt = timeFormatter.exec(teamLog.getUpdateDate());
                if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                    total += playerLog.getStat();
                    if (flag){
                        total += playerLog.getStat();
                    }
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("jgl", playerLog.getStat(), Integer::sum);
                }
            }
        }

        flag = teamLog.getMidId().equals(teamLog.getMvpId());

        // 미드선수 stat 누적 구하기
        for (PlayerLog playerLog : midPlayers){
            LocalDateTime playerLogDate = timeFormatter.exec(playerLog.getDate());

            if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                total += playerLog.getStat();
                if (flag){
                    total += playerLog.getStat();
                }
                // 결과 맵에 데이터 추가
                resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                        .computeIfAbsent(weekEnum, k -> new HashMap<>())
                        .merge("mid", playerLog.getStat(), Integer::sum);
            }
            else if (teamLog.getUpdateDate() != null){
                LocalDateTime updateAt = timeFormatter.exec(teamLog.getUpdateDate());
                if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                    total += playerLog.getStat();
                    if (flag){
                        total += playerLog.getStat();
                    }
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("mid", playerLog.getStat(), Integer::sum);
                }
            }
        }

        flag = teamLog.getAdcId().equals(teamLog.getMvpId());
        // 원딜선수 stat 누적 구하기
        for (PlayerLog playerLog : adcPlayers){
            LocalDateTime playerLogDate = timeFormatter.exec(playerLog.getDate());

            if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                total += playerLog.getStat();
                if (flag){
                    total += playerLog.getStat();
                }
                // 결과 맵에 데이터 추가
                resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                        .computeIfAbsent(weekEnum, k -> new HashMap<>())
                        .merge("adc", playerLog.getStat(), Integer::sum);
            }
            else if (teamLog.getUpdateDate() != null){
                LocalDateTime updateAt = timeFormatter.exec(teamLog.getUpdateDate());
                if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                    total += playerLog.getStat();
                    if (flag){
                        total += playerLog.getStat();
                    }
                    // 결과 맵에 데이터 추가
                    resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                            .computeIfAbsent(weekEnum, k -> new HashMap<>())
                            .merge("adc", playerLog.getStat(), Integer::sum);
                }
            }
        }

        flag = teamLog.getSupId().equals(teamLog.getMvpId());
        // 서폿선수 stat 누적 구하기
        for (PlayerLog playerLog : supPlayers){
            LocalDateTime playerLogDate = timeFormatter.exec(playerLog.getDate());

            if ((teamLog.getUpdateDate() == null) && playerLogDate.isAfter(createDate)){
                total += playerLog.getStat();
                if (flag){
                    total += playerLog.getStat();
                }
                // 결과 맵에 데이터 추가
                resultMap.computeIfAbsent(oauthId, k -> new HashMap<>())
                        .computeIfAbsent(weekEnum, k -> new HashMap<>())
                        .merge("sup", playerLog.getStat(), Integer::sum);
            }
            else if (teamLog.getUpdateDate() != null){
                LocalDateTime updateAt = timeFormatter.exec(teamLog.getUpdateDate());
                if (playerLogDate.isAfter(createDate) && playerLogDate.isBefore(updateAt)){

                    total += playerLog.getStat();
                    if (flag){
                        total += playerLog.getStat();
                    }
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

        return resultMap;
    }
}
