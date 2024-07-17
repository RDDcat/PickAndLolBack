package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Aspect.TimeRestricted;
import com.pickandlol.pickandlol.Model.RequestTeamLogSaveDTO;
import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TeamController {

    TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/sync/{oauthId}")
    public ResponseTeamGetDTO sync(@PathVariable String oauthId){
        return teamService.getTeam(oauthId);
    }

    // 팀 저장
    @TimeRestricted
    @PostMapping("/save")
    public String save(@RequestBody RequestTeamSaveDTO requestTeamSaveDTO){
        return teamService.saveTeam(requestTeamSaveDTO);
    }

    // 팀 로그 저장
    @TimeRestricted
    @PostMapping("/team/log")
    public String saveTeamLog(@RequestBody RequestTeamLogSaveDTO requestTeamLogSaveDTO){
        return teamService.saveTeamLog(requestTeamLogSaveDTO);
    }

    // 랭킹
    @GetMapping("/rank")
    public List<ResponseTeamGetDTO> rank(){
        return teamService.getRank();
    }

    // 팁 변동 가능 전체 수정
    @PutMapping("/team/change")
    public boolean updateTeamCanChange(){
        return teamService.updateTeamCanChange();
    }
}
