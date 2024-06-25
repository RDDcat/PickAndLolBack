package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/team")
public class TeamController {

    TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    // 팀 전체 조회
    @GetMapping("/all")
    public List<ResponseTeamGetDTO> getTeams(){
        return teamService.getTeams();
    }
}
