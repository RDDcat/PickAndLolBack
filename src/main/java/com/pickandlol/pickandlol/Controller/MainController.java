package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Aspect.TimeRestricted;
import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.TeamDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String health(){
        return "server on health check";
    }
    // 팀 저장
    @TimeRestricted
    @PostMapping("/save")
    public String save(@RequestBody TeamDTO teamDTO){
        System.out.println("teamDTO : "+teamDTO);
        return "server save";
    }
    // 랭킹
    @GetMapping("/rank")
    public String rank(){
        return "server on health check";
    }
    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Member member){
        return "login successful";
    }

}
