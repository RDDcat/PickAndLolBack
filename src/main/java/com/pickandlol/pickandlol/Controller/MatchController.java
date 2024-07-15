package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.*;
import com.pickandlol.pickandlol.Service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/match")
public class MatchController {

    MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    // 경기 전체 조회
    @GetMapping("")
    public List<ResponseMatchGetDTO> getMatchs() {
        return matchService.getMatchs();
    }

    // 경기 정보 저장
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveMatch(@RequestBody RequestMatchSaveDTO requestMatchSaveDTO) {
        MatchDAO matchId = matchService.saveMatch(requestMatchSaveDTO);

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (matchId == null) ? "경기 정보 저장 실패" : "경기 정보 저장 성공");
        requestMap.put("matchId", matchId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


    // 경기 - 팀 정보 저장
    @PostMapping("/club")
    public ResponseEntity<Map<String, Object>> saveMatchTeam(@RequestBody RequestClubLogSaveDTO requestClubLogSaveDTO) {
        Long clubLogId = matchService.saveMatchTeam(requestClubLogSaveDTO);

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (clubLogId == null) ? "팀 정보 저장 실패" : "팀 정보 저장 성공");
        requestMap.put("clubLogId", clubLogId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }

    // 경기 - 선수 정보 저장
    @PostMapping("/player")
    public ResponseEntity<Map<String, Object>> saveMatchPlayer(@RequestBody RequestPlayerLogSaveDTO requestPlayerLogSaveDTO) {
        Long playerLogId = matchService.saveMatchPlayer(requestPlayerLogSaveDTO);

        // 메시지와 id 값 json 데이터로 반환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("message", (playerLogId == null) ? "선수 정보 저장 실패" : "선수 정보 저장 성공");
        requestMap.put("playerLogId", playerLogId);

        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }
}