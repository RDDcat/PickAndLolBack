package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.RequestMatchPlayerSaveDTO;
import com.pickandlol.pickandlol.Model.RequestMatchTeamSaveDTO;
import com.pickandlol.pickandlol.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/match")
public class MatchController {

    MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    // 경기 - 팀 정보 저장
    @PostMapping("/team")
    public ResponseEntity<Map<String, Object>> saveMatchTeam(@RequestBody RequestMatchTeamSaveDTO requestMatchTeamSaveDTO) {
        Long matchTeamId = matchService.saveMatchTeam(requestMatchTeamSaveDTO);

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (matchTeamId == null) ? "팀 정보 저장 실패" : "팀 정보 저장 성공");
        requestMap.put("matchTeamId", matchTeamId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 경기 - 선수 정보 저장
    @PostMapping("/player")
    public ResponseEntity<Map<String, Object>> saveMatchPlayer(@RequestBody RequestMatchPlayerSaveDTO requestMatchPlayerSaveDTO) {
        Long matchPlayerId = matchService.saveMatchPlayer(requestMatchPlayerSaveDTO);

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (matchPlayerId == null) ? "선수 정보 저장 실패" : "선수 정보 저장 성공");
        requestMap.put("matchPlayerId", matchPlayerId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}