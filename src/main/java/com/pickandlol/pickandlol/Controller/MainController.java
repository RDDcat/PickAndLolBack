package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Aspect.TimeRestricted;
import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.TeamDAO;
import com.pickandlol.pickandlol.Model.TeamDTO;
import com.pickandlol.pickandlol.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MainController {
    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/")
    public String health(){
        return "server on health check";
    }

    @GetMapping("/sync/{oauthId}")
    public TeamDTO sync(@PathVariable String oauthId){
        TeamDAO teamDAO = teamRepository.findByOauthId(oauthId);
        TeamDTO teamDTO = new TeamDTO(teamDAO.getOauthId(), teamDAO.getData());
        return teamDTO;
    }
    // 팀 저장
    @TimeRestricted
    @PostMapping("/save")
    public String save(@RequestBody TeamDTO teamDTO){
        System.out.println("teamDTO : "+teamDTO);
        TeamDAO teamDAO = new TeamDAO();
        teamDAO.setData(teamDTO.getData());
        teamDAO.setOauthId(teamDTO.getOauthId());
        teamRepository.save(teamDAO);
        return "server save";
    }
    // 랭킹
    @GetMapping("/rank")
    public List<TeamDAO> rank(){
        return teamRepository.findAll();
    }
    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Member member){
        return "login successful";
    }

}
