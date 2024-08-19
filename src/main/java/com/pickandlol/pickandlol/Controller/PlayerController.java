package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.RequestPlayerVPUpdateDTO;
import com.pickandlol.pickandlol.Model.DTO.ResponsePlayerGetDTO;
import com.pickandlol.pickandlol.Service.PlayerService;
import com.pickandlol.pickandlol.jose.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/player")
@Tag(name = "Player", description = "선수 정보 관련 API")
public class PlayerController {

    PlayerService playerService;
    JwtUtil jwtUtil;

    @Autowired
    public PlayerController(JwtUtil jwtUtil, PlayerService playerService){
        this.jwtUtil = jwtUtil;
        this.playerService = playerService;
    }

    // 선수 전체 조회
    @Operation(summary = "선수 전체 조회", description = "메인에서 보여줄 선수 전체 정보를 조회하기 위한 API")
    @GetMapping("/all")
    public List<ResponsePlayerGetDTO> getPlayers(){
        return playerService.getPlayers();
    }

    // 선수 VP 로그 저장
    @Operation(summary = "선수 VP 로그 저장", description = "선수 VP 변동 관련 로그를 저장하기 위한 API")
    @PostMapping("/log")
    public String savePlayerVPLogs(){
        return playerService.savePlayerVPLogs();
    }

    // 선수 VP 수정 (전체)
    @Operation(summary = "선수 VP 수정", description = "Int 값을 입력받아 입력받은 그대로 선수 VP를 수정하기 위한 API")
    @PutMapping("/vp")
    public String updatePlayerVP(@RequestBody RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO){
        return playerService.updatePlayerVP(requestPlayerVPUpdateDTO);
    }

    // 선수 VP 수정 (일부)
    @Operation(summary = "선수 VP 일부 수정", description = "Int 값을 입력받아 입력받은 만큼 증감시켜 선수 VP를 수정하기 위한 API")
    @PutMapping("/vp/plus")
    public String updatePlayerVPPlus(@RequestBody RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO){
        return playerService.updatePlayerVPPlus(requestPlayerVPUpdateDTO);
    }

}
