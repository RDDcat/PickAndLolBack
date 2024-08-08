package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DAO.Member;
import com.pickandlol.pickandlol.Model.DTO.RequestMemberRefreshTokenDTO;
import com.pickandlol.pickandlol.Service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@RestController
@CrossOrigin("*")
public class MainController {

    MemberService memberService;

    @Autowired
    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String health(){
        return "server on health check";
    }

    @GetMapping("/health")
    public HttpEntity<Object> healthCheck(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<?> token(@PathVariable(value = "token") String token, HttpServletResponse response) throws IOException {

        System.out.println("token = " + token);
        Map<String, String> map = memberService.getAccessToken(token);

        if (map.get("accessToken") == null || map.get("refreshToken") == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("token not found");
        }

        return ResponseEntity.ok(map);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RequestMemberRefreshTokenDTO requestMemberRefreshTokenDTO, HttpServletResponse response) throws IOException {

        String accessToken = memberService.reissueAccessToken(requestMemberRefreshTokenDTO);

        if (accessToken == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("token not found");
        }

        return ResponseEntity.ok(Map.of("accessToken", accessToken));
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
