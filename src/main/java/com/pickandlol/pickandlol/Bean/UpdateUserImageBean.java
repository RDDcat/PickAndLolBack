package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetMemberDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveMemberDAOBean;
import com.pickandlol.pickandlol.Model.DAO.Member;
import com.pickandlol.pickandlol.Model.DTO.RequestMemberImageUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserImageBean {

    GetMemberDAOBean getMemberDAOBean;
    SaveMemberDAOBean saveMemberDAOBean;

    @Autowired
    public UpdateUserImageBean(GetMemberDAOBean getMemberDAOBean, SaveMemberDAOBean saveMemberDAOBean) {
        this.getMemberDAOBean = getMemberDAOBean;
        this.saveMemberDAOBean = saveMemberDAOBean;
    }

    // 맴버 이미지 변경
    public String exec(RequestMemberImageUpdateDTO requestMemberImageUpdateDTO) {

        // 맴버 찾기
        Member member = getMemberDAOBean.exec(requestMemberImageUpdateDTO.getOauthId());
        if (member == null) return "fail";

        // 맴버 이미지 변경
        member.update(null, null, requestMemberImageUpdateDTO.getImageUrl());

        // 맴버 저장
        saveMemberDAOBean.exec(member);

        return "success";
    }
}
