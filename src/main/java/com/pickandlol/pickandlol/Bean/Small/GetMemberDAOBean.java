package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.Member;
import com.pickandlol.pickandlol.Repository.MemberRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMemberDAOBean {

    MemberRepositoryJPA memberRepositoryJPA;

    @Autowired
    public GetMemberDAOBean(MemberRepositoryJPA memberRepositoryJPA) {
        this.memberRepositoryJPA = memberRepositoryJPA;
    }

    // 맴버 찾기
    public Member exec(String oauthId) {
        return memberRepositoryJPA.findByOauthId(oauthId);
    }
}
