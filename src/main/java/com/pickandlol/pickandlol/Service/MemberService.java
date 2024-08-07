package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.*;
import com.pickandlol.pickandlol.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    GetAccessTokenBean getAccessTokenBean;
    ReissueAccessTokenBean reissueAccessTokenBean;
    GetMemberBean getMemberBean;
    UpdateMemberNameBean updateMemberNameBean;
    UpdateUserImageBean updateUserImageBean;
    DeleteMemberBean deleteMemberBean;

    @Autowired
    public MemberService(GetAccessTokenBean getAccessTokenBean, ReissueAccessTokenBean reissueAccessTokenBean, GetMemberBean getMemberBean, UpdateMemberNameBean updateMemberNameBean, UpdateUserImageBean updateUserImageBean, DeleteMemberBean deleteMemberBean) {
        this.getAccessTokenBean = getAccessTokenBean;
        this.reissueAccessTokenBean = reissueAccessTokenBean;
        this.getMemberBean = getMemberBean;
        this.updateMemberNameBean = updateMemberNameBean;
        this.updateUserImageBean = updateUserImageBean;
        this.deleteMemberBean = deleteMemberBean;
    }

    // 토큰 체크
    public Map<String, String> getAccessToken(String token) {
        System.out.println("token = " + token);
        return getAccessTokenBean.exec(token);
    }

    // 액세스 토큰 재발급
    public String reissueAccessToken(RequestMemberRefreshTokenDTO requestMemberRefreshTokenDTO) {
        return reissueAccessTokenBean.exec(requestMemberRefreshTokenDTO);
    }

    // 맴버 조회
    public ResponseMemberGetDTO getMember(RequestMemberGetDTO requestMemberGetDTO) {
        return getMemberBean.exec(requestMemberGetDTO);
    }

    // 맴버 이름 변경
    public String updateMemberName(RequestMemberNameUpdateDTO requestMemberNameUpdateDTO) {
        return updateMemberNameBean.exec(requestMemberNameUpdateDTO);
    }

    // 맴버 이미지 변경
    public String updateUserImage(RequestMemberImageUpdateDTO requestMemberImageUpdateDTO) {
        return updateUserImageBean.exec(requestMemberImageUpdateDTO);
    }

    // 맴버 삭제
    public String deleteMember(RequestMemberDeleteDTO requestMemberDeleteDTO) {
        return deleteMemberBean.exec(requestMemberDeleteDTO);
    }
}
