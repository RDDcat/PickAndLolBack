package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.*;
import com.pickandlol.pickandlol.Service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@RestController
@CrossOrigin("*")
@Tag(name = "Member", description = "유저 관련 API")
public class MemberController {

    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 유저 조회
    @Operation(summary = "유저 조회", description = "유저 정보를 조회하기 위한 API")
    @PostMapping("/member")
    public ResponseMemberGetDTO getMember(@RequestBody RequestMemberGetDTO requestMemberGetDTO){
        return memberService.getMember(requestMemberGetDTO);
    }

    // 유저 이름 변경
    @Operation(summary = "유저 이름 변경", description = "유저 이름을 변경하기 위한 API")
    @PutMapping("/member/name")
    public String updateMemberName(@RequestBody RequestMemberNameUpdateDTO requestMemberNameUpdateDTO){
        return memberService.updateMemberName(requestMemberNameUpdateDTO);
    }

    // 유저 이미지 변경
    @Operation(summary = "유저 이미지 변경", description = "유저 이미지를 변경하기 위한 API")
    @PutMapping("/member/image")
    public String updateUserImage(@RequestBody RequestMemberImageUpdateDTO requestMemberImageUpdateDTO){
        return memberService.updateUserImage(requestMemberImageUpdateDTO);
    }

    // 유저 삭제
    @Operation(summary = "유저 삭제", description = "유저를 삭제하기 위한 API")
    @DeleteMapping("/member")
    public String deleteMember(@RequestBody RequestMemberDeleteDTO requestMemberDeleteDTO){
        return memberService.deleteMember(requestMemberDeleteDTO);
    }

    // 유저 로그인 토큰으로 access, refresh token 발급
    @Operation(summary = "유저 로그인 후 토큰 발급", description = "유저 로그인 후 JWT로 access, refresh token을 발급하기 위한 API")
    @GetMapping("/token/{token}")
    public ResponseEntity<?> token(@PathVariable(value = "token") String token, HttpServletResponse response) throws IOException {

        Map<String, String> map = memberService.getAccessToken(token);

        if (map.get("accessToken") == null || map.get("refreshToken") == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("token not found");
        }

        return ResponseEntity.ok(map);
    }

    // 유저 refresh token으로 access token 재발급
    @Operation(summary = "유저 refresh token으로 access token 재발급", description = "refresh token으로 access token을 재발급하기 위한 API")
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody RequestMemberRefreshTokenDTO requestMemberRefreshTokenDTO, HttpServletResponse response) throws IOException {

        String accessToken = memberService.reissueAccessToken(requestMemberRefreshTokenDTO);

        if (accessToken == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("token not found");
        }

        return ResponseEntity.ok(Map.of("accessToken", accessToken));
    }
}
