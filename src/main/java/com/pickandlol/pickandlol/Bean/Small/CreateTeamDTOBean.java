package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.TeamsDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateTeamDTOBean {

    public ResponseTeamGetDTO exec(TeamsDAO teamsDAO){
        return ResponseTeamGetDTO.builder()
                .teamId(teamsDAO.getTeamId())
                .teamLogo(teamsDAO.getTeamLogo())
                .teamName(teamsDAO.getTeamName())
                .winCount(teamsDAO.getWinCount())
                .loseCount(teamsDAO.getLoseCount())
                .totalGap(teamsDAO.getTotalGap())
                .winRate(teamsDAO.getWinRate())
                .kda(teamsDAO.getKda())
                .kill(teamsDAO.getKill())
                .death(teamsDAO.getDeath())
                .assist(teamsDAO.getAssist())
                .build();
    }

    public List<ResponseTeamGetDTO> exec(List<TeamsDAO> teamsDAOS){
        return teamsDAOS.stream()
                .map(this::exec)
                .toList();
    }
}