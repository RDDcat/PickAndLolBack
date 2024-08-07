package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetMemberDAOBean;
import com.pickandlol.pickandlol.Bean.Small.GetMemberTokenDAOBean;
import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.MemberTokenDAO;
import com.pickandlol.pickandlol.Model.RequestMemberGetDTO;
import com.pickandlol.pickandlol.Model.ResponseMemberGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMemberBean {

    GetMemberTokenDAOBean getMemberTokenDAOBean;
    GetMemberDAOBean getMemberDAOBean;

    @Autowired
    public GetMemberBean(GetMemberTokenDAOBean getMemberTokenDAOBean, GetMemberDAOBean getMemberDAOBean) {
        this.getMemberTokenDAOBean = getMemberTokenDAOBean;
        this.getMemberDAOBean = getMemberDAOBean;
    }

    public ResponseMemberGetDTO exec(RequestMemberGetDTO requestMemberGetDTO) {

        MemberTokenDAO memberTokenDAO = getMemberTokenDAOBean.exec(requestMemberGetDTO);

        Member member = getMemberDAOBean.exec(memberTokenDAO.getOauthId());

        return ResponseMemberGetDTO.builder()
                .name(member.getName())
                .oauthId(member.getOauthId())
                .build();
    }

}
