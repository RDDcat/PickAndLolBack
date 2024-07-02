package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Aspect.TimeRestricted;
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

    // 랭킹
    @GetMapping("/rank")
    public List<ResponseTeamGetDTO> rank(){
        return teamService.getRank();
    }
}
