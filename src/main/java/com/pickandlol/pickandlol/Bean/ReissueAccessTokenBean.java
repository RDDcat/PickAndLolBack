package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.DeleteMemberTokenDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetMemberTokenDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveMemberTokenDAOBean;
import com.pickandlol.pickandlol.Model.DAO.MemberTokenDAO;
import com.pickandlol.pickandlol.Model.DTO.RequestMemberRefreshTokenDTO;
import com.pickandlol.pickandlol.jose.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReissueAccessTokenBean {

    GetMemberTokenDAOBean getMemberTokenDAOBean;
    DeleteMemberTokenDAOBean deleteMemberTokenDAOBean;
    SaveMemberTokenDAOBean saveMemberTokenDAOBean;
    JwtUtil jwtUtil;

    @Autowired
    public ReissueAccessTokenBean(GetMemberTokenDAOBean getMemberTokenDAOBean, DeleteMemberTokenDAOBean deleteMemberTokenDAOBean, SaveMemberTokenDAOBean saveMemberTokenDAOBean, JwtUtil jwtUtil) {
        this.getMemberTokenDAOBean = getMemberTokenDAOBean;
        this.deleteMemberTokenDAOBean = deleteMemberTokenDAOBean;
        this.saveMemberTokenDAOBean = saveMemberTokenDAOBean;
        this.jwtUtil = jwtUtil;
    }

    public String exec(RequestMemberRefreshTokenDTO requestMemberRefreshTokenDTO) {

        // 리프레시 토큰을 통해 MemberTokenDAO 객체 찾기
        MemberTokenDAO memberTokenDAO = getMemberTokenDAOBean.exec(requestMemberRefreshTokenDTO.getRefreshToken());
        if (memberTokenDAO == null) return null;

        // 리프레시 토큰이 유효하지 않을 때
        if (!jwtUtil.validateToken(requestMemberRefreshTokenDTO.getRefreshToken())) {
            deleteMemberTokenDAOBean.exec(memberTokenDAO);
            return null;
        }

        // 액세스 토큰 재발급
        String generateAccessToken = jwtUtil.generateAccessToken(memberTokenDAO);

        memberTokenDAO.setAccessToken(generateAccessToken);

        saveMemberTokenDAOBean.exec(memberTokenDAO);

        // 액세스 토큰 반환
        return generateAccessToken;
    }
}