package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Service.TeamStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
