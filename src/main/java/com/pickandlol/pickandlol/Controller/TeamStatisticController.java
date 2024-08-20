package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.ResponseTeamStatisticGetDTO;
import com.pickandlol.pickandlol.Service.TeamStatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/team/statistic")
@Tag(name = "TeamStatistic", description = "유저 팀 통계 관련 API")
public class TeamStatisticController {

    TeamStatisticService teamStatisticService;

    @Autowired
    public TeamStatisticController(TeamStatisticService teamStatisticService){
        this.teamStatisticService = teamStatisticService;
    }

    // 팀 통계 저장
    @Operation(summary = "유저 팀 통계 저장", description = "유저 팀 통계 저장 API")
    @PostMapping("")
    public void saveTeamStatistic(){
        teamStatisticService.saveTeamStatistic();
    }

    // 팀 통계 조회
    @Operation(summary = "유저 팀 통계 전체 조회", description = "유저 팀 통계 전체 조회 API")
    @GetMapping("")
    public List<ResponseTeamStatisticGetDTO> getTeamStatistics(){
        return teamStatisticService.getTeamStatistics();
    }
}
