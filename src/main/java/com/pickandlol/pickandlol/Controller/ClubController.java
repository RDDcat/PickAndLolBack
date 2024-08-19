package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.ResponseClubGetDTO;
import com.pickandlol.pickandlol.Service.ClubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/club")
@Tag(name = "Club", description = "구단 관련 API")
public class ClubController {

    ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }

    // 팀 전체 조회
    @Operation(summary = "구단 전체 조회", description = "구단 순위를 조회를 위한 API")
    @GetMapping("/all")
    public List<ResponseClubGetDTO> getTeams(){
        return clubService.getTeams();
    }
}
