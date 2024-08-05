package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin("*")
public class MainController {

    MemberService memberService;

    @Autowired

    @GetMapping("/")
    public String health(){
        return "server on health check";
    }

    @GetMapping("/health")
    public HttpEntity<Object> healthCheck(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/{token}")
    public void token(@PathVariable(value = "token") String token, HttpServletResponse response) throws IOException {
        String accessToken = memberService.getAccessToken(token);

        if (accessToken == null) {
            response.sendError(HttpStatus.NOT_FOUND.value(), "Access token not found");
            return;
        }

        // HTTP response header에 access-token 설정
        response.setHeader("access-token", accessToken);
    }


    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Member member){
        return "login successful";
    }

    // 로그인
    @PostMapping("/test")
    public String login(@RequestBody String data){
        return "test successful"+data;
    }

}
