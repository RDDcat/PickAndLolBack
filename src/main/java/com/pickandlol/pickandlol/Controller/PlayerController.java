package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.ResponsePlayerGetDTO;
import com.pickandlol.pickandlol.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/player")
public class PlayerController {

    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    // 선수 전체 조회
    @GetMapping("/all")
    public List<ResponsePlayerGetDTO> getPlayers(){
        return playerService.getPlayers();
    }

}
