package com.pickandlol.pickandlol.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pickandlol.pickandlol.Aspect.TimeRestricted;
import com.pickandlol.pickandlol.Model.DTO.RequestTeamLogSaveDTO;
import com.pickandlol.pickandlol.Model.DTO.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.DTO.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Tag(name = "Team", description = "유저 팀 관련 API")
public class TeamController {

    TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @Operation(summary = "유저 팀 조회", description = "유저가 선택한 팀을 조회하기 위한 API")
    @GetMapping("/sync/{oauthId}")
    public ResponseTeamGetDTO sync(@PathVariable String oauthId) throws JsonProcessingException {
        return teamService.getTeam(oauthId);
    }

    // 팀 저장
    @Operation(summary = "유저 팀 저장 및 업데이트", description = "유저 팀 저장 및 업데이트를 하기 위한 API")
    @TimeRestricted
    @PostMapping("/save")
    public String save(@RequestBody RequestTeamSaveDTO requestTeamSaveDTO) throws JsonProcessingException {
        return teamService.saveTeam(requestTeamSaveDTO);
    }

    // 팀 로그 저장
    @Operation(summary = "유저 팀 로그 저장", description = "유저 팀 로그 저장을 하기 위한 API")
    @TimeRestricted
    @PostMapping("/team/log")
    public String saveTeamLog(@RequestBody RequestTeamLogSaveDTO requestTeamLogSaveDTO){
        return teamService.saveTeamLog(requestTeamLogSaveDTO);
    }

    // 랭킹
    @Operation(summary = "유저 팀 랭킹 조회", description = "유저 팀 랭킹 조회를 하기 위한 API")
    @GetMapping("/rank")
    public List<ResponseTeamGetDTO> rank() throws JsonProcessingException {
        return teamService.getRank();
    }

    // 팁 변동 가능 전체 수정
    @Operation(summary = "팀 변동 가능 전체 수정", description = "팀 변동 가능 전체 수정")
    @PutMapping("/team/change/possible")
    public boolean updateTeamCanChange(){
        return teamService.updateTeamCanChange();
    }

    // 팁 변동 가능 전체 수정
    @Operation(summary = "팀 변동 불가능 전체 수정", description = "팀 변동 불가능 전체 수정")
    @PutMapping("/team/change/impossible")
    public boolean updateTeamCanChangeImpossible(){
        return teamService.updateTeamCanChangeImpossible();
    }
}
