package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Model.DTO.*;
import com.pickandlol.pickandlol.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberController {

    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 유저 조회
    @PostMapping("")
    public ResponseMemberGetDTO getMember(@RequestBody RequestMemberGetDTO requestMemberGetDTO){
        return memberService.getMember(requestMemberGetDTO);
    }

    // 유저 이름 변경
    @PutMapping("/name")
    public String updateMemberName(@RequestBody RequestMemberNameUpdateDTO requestMemberNameUpdateDTO){
        return memberService.updateMemberName(requestMemberNameUpdateDTO);
    }

    // 유저 이미지 변경
    @PutMapping("/image")
    public String updateUserImage(@RequestBody RequestMemberImageUpdateDTO requestMemberImageUpdateDTO){
        return memberService.updateUserImage(requestMemberImageUpdateDTO);
    }

    // 유저 삭제
    @DeleteMapping
    public String deleteMember(@RequestBody RequestMemberDeleteDTO requestMemberDeleteDTO){
        return memberService.deleteMember(requestMemberDeleteDTO);
    }
}
