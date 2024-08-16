package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.RequestPlayerVPUpdateDTO;
import com.pickandlol.pickandlol.Model.DTO.ResponsePlayerGetDTO;
import com.pickandlol.pickandlol.Service.PlayerService;
import com.pickandlol.pickandlol.jose.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/player")
public class PlayerController {

    PlayerService playerService;
    JwtUtil jwtUtil;

    @Autowired
    public PlayerController(JwtUtil jwtUtil, PlayerService playerService){
        this.jwtUtil = jwtUtil;
        this.playerService = playerService;
    }

    // 선수 전체 조회
    @GetMapping("/all")
    public List<ResponsePlayerGetDTO> getPlayers(){
        return playerService.getPlayers();
    }

    // 선수 VP 로그 저장
    @PostMapping("/log")
    public String savePlayerVPLogs(){
        return playerService.savePlayerVPLogs();
    }

    // 선수 VP 수정 (전체)
    @PutMapping("/vp")
    public String updatePlayerVP(@RequestBody RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO){
        return playerService.updatePlayerVP(requestPlayerVPUpdateDTO);
    }

    // 선수 VP 수정 (일부)
    @PutMapping("/vp/plus")
    public String updatePlayerVPPlus(@RequestBody RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO){
        return playerService.updatePlayerVPPlus(requestPlayerVPUpdateDTO);
    }

}
