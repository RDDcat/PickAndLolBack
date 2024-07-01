package com.pickandlol.pickandlol.Bean.Small;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
import com.pickandlol.pickandlol.Model.MatchDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateMatchDAOBean {

    private static final int  OneSet= 1;
    private static final int  TwoGame= 4;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public void exec(MatchDAO matchDAO, List<ClubLog> clubLogList){

        // 경기 상태 설정
        matchDAO.setMatchStatus(MatchStatus.PLAYING);

        // 2경기 이상 진행되지 않았다면 return
        if (clubLogList.size() < TwoGame) return;

        int homeWinCount = 0;
        int awayWinCount = 0;
        List<Long> clubLogIdList = new ArrayList<>();

        // 2경기 이상 진행되었을 때, 2승을 달성한 팀이 있는지 확인
        for (ClubLog clubLog : clubLogList) {
            MatchResult matchResult = clubLog.getMatchResult();
            clubLogIdList.add(clubLog.getClubLogId());

            // 이긴 팀의 승점 추가
            if (matchResult == MatchResult.WIN) {
                if (clubLog.getClubId().equals(matchDAO.getHomeClubId())) {
                    homeWinCount++;
                } else {
                    awayWinCount++;
                }
            }
        }

        // 2승을 달성한 팀이 없다면 return
        if (homeWinCount < 2 && awayWinCount < 2) return;

        // 2승을 달성한 팀이 있다면, 해당 팀을 승자로 설정
        if (homeWinCount > OneSet) {
            matchDAO.setWinnerClubId(matchDAO.getHomeClubId());
        } else {
            matchDAO.setLoserClubId(matchDAO.getHomeClubId());
        }

        // 스코어 설정
        matchDAO.setHomeScore(homeWinCount);
        matchDAO.setAwayScore(awayWinCount);

        // 경기 상태 설정
        matchDAO.setMatchStatus(MatchStatus.END);

        // 게임에 해당하는 club log id를 matchDAO에 저장
        try {
            String clubLogIds = objectMapper.writeValueAsString(clubLogIdList);
            matchDAO.setClubLogId(clubLogIds);
        }catch (JsonProcessingException e) {
            System.out.println("Failed to map Object to JSON: " + e.getMessage());
        }
    }
}
