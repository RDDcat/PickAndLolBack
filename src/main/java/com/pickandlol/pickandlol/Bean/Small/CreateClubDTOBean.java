package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ResponseClubGetDTO;
import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateClubDTOBean {

    public ResponseClubGetDTO exec(ClubDAO clubDAO){
        return ResponseClubGetDTO.builder()
                .teamId(clubDAO.getTeamId())
                .teamLogo(clubDAO.getTeamLogo())
                .teamName(clubDAO.getTeamName())
                .winCount(clubDAO.getWinCount())
                .loseCount(clubDAO.getLoseCount())
                .totalGap(clubDAO.getTotalGap())
                .winRate(clubDAO.getWinRate())
                .kda(clubDAO.getKda())
                .killCount(clubDAO.getKillCount())
                .deathCount(clubDAO.getDeathCount())
                .assistCount(clubDAO.getAssistCount())
                .build();
    }

    public List<ResponseClubGetDTO> exec(List<ClubDAO> clubDAOS){
        return clubDAOS.stream()
                .map(this::exec)
                .toList();
    }
}