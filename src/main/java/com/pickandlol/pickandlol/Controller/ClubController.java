package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.ResponseClubGetDTO;
import com.pickandlol.pickandlol.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/team")
public class ClubController {

    ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    // 팀 전체 조회
    @GetMapping("/all")
    public List<ResponseClubGetDTO> getTeams(){
        return clubService.getTeams();
    }
}
