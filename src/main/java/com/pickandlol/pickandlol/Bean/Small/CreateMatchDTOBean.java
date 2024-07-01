package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.ResponseMatchGetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateMatchDTOBean {

    public ResponseMatchGetDTO exec(MatchDAO matchDAO){
        return ResponseMatchGetDTO.builder()
                .matchId(matchDAO.getMatchId())
                .matchNum(matchDAO.getMatchNum())
                .homeClubId(matchDAO.getHomeClubId())
                .awayClubId(matchDAO.getAwayClubId())
                .stadium(matchDAO.getStadium())
                .year(matchDAO.getYear())
                .month(matchDAO.getMonth())
                .day(matchDAO.getDay())
                .dayOfTheWeek(matchDAO.getDayOfTheWeek())
                .time(matchDAO.getTime())
                .round(matchDAO.getRound())
                .homeScore(matchDAO.getHomeScore())
                .awayScore(matchDAO.getAwayScore())
                .matchStatus(matchDAO.getMatchStatus().toString())
                .clubLogId(matchDAO.getClubLogId())
                .build();
    }

    public List<ResponseMatchGetDTO> exec(List<MatchDAO> matchDAOS){
        return matchDAOS.stream().map(this::exec).toList();
    }
}
