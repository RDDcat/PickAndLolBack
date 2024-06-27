package com.pickandlol.pickandlol.Bean.Small;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.MatchResult;
import com.pickandlol.pickandlol.Model.MatchDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UpdateMatchDAOBean {

    private static final int  OneSet= 1;
    private static final int  TwoGame= 4;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public void exec(MatchDAO matchDAO, List<ClubLog> clubLogList){

        // 2경기 이상 진행되지 않았다면 return
        if (clubLogList.size() < TwoGame) return;

        Map<Long, Integer> winCountMap = new HashMap<>();
        List<Long> clubLogIdList = new ArrayList<>();
        boolean hasTwoWins = false;

        // 2경기 이상 진행되었을 때, 2승을 달성한 팀이 있는지 확인
        for (ClubLog clubLog : clubLogList) {
            Long clubId = clubLog.getClubId();
            MatchResult matchResult = clubLog.getMatchResult();
            clubLogIdList.add(clubLog.getClubLogId());

            if (matchResult == MatchResult.WIN) {
                winCountMap.put(clubId, winCountMap.getOrDefault(clubId, 0) + 1);
                if (winCountMap.get(clubId) == 2) {
                    hasTwoWins = true;
                }
            }
            else if (matchResult == MatchResult.LOSE) {
                // 패배한 팀도 winCountMap에 추가, 이미 있는 경우 값 변화 없음
                winCountMap.putIfAbsent(clubId, 0);
            }
        }

        // 2승을 달성한 팀이 없다면 return
        if (!hasTwoWins) return;

        // 2승을 달성한 팀이 있다면, 해당 팀을 승자로 설정
        for (Map.Entry<Long, Integer> entry : winCountMap.entrySet()) {
            Long clubId = entry.getKey();
            Integer winCount = entry.getValue();

            if (winCount > OneSet) {
                matchDAO.setWinnerTeamId(clubId);
            }else {
                matchDAO.setLoserTeamId(clubId);
            }
        }

        // 게임에 해당하는 club log id를 matchDAO에 저장
        try {
            String clubLogIds = objectMapper.writeValueAsString(clubLogIdList);
            matchDAO.setClubLogId(clubLogIds);
        }catch (JsonProcessingException e) {
            System.out.println("Failed to map Object to JSON: " + e.getMessage());
        }
    }
}
