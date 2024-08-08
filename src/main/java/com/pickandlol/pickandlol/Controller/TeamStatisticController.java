package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.ResponseTeamStatisticGetDTO;
import com.pickandlol.pickandlol.Service.TeamStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/team/statistic")
public class TeamStatisticController {

    TeamStatisticService teamStatisticService;

    @Autowired
    public TeamStatisticController(TeamStatisticService teamStatisticService){
        this.teamStatisticService = teamStatisticService;
    }

    // 팀 통계 저장
    @PostMapping("")
    public void saveTeamStatistic(){
        teamStatisticService.saveTeamStatistic();
    }

    // 팀 통계 조회
    @GetMapping("")
    public List<ResponseTeamStatisticGetDTO> getTeamStatistics(){
        return teamStatisticService.getTeamStatistics();
    }
}
