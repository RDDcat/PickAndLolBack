package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Aspect.TimeRestricted;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String health(){
        return "server on health check";
    }
    @TimeRestricted
    @GetMapping("/save")
    public String save(){
        return "server on health check";
    }
    // 랭킹
    @GetMapping("/rank")
    public String rank(){
        return "server on health check";
    }
    // 로그인
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
