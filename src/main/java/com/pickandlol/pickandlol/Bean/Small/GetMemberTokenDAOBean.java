package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.MemberTokenDAO;
import com.pickandlol.pickandlol.Repository.MemberTokenRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetMemberTokenDAOBean {

    MemberTokenRepositoryJPA memberTokenRepositoryJPA;

    @Autowired
    public GetMemberTokenDAOBean(MemberTokenRepositoryJPA memberTokenRepositoryJPA) {
        this.memberTokenRepositoryJPA = memberTokenRepositoryJPA;
    }

    public MemberTokenDAO exec(String refreshToken) {
        return memberTokenRepositoryJPA.findByRefreshToken(refreshToken);
    }
}
