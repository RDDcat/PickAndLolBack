package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class MainController {
    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/")
    public String health(){
        return "server on health check";
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Member member){
        return "login successful";
    }

}
