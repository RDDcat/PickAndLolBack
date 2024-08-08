package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.MemberTokenDAO;
import com.pickandlol.pickandlol.Repository.MemberTokenRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteMemberTokenDAOBean {

    MemberTokenRepositoryJPA memberTokenRepositoryJPA;

    @Autowired
    public DeleteMemberTokenDAOBean(MemberTokenRepositoryJPA memberTokenRepositoryJPA) {
        this.memberTokenRepositoryJPA = memberTokenRepositoryJPA;
    }

    public void exec(MemberTokenDAO memberTokenDAO) {
        memberTokenRepositoryJPA.delete(memberTokenDAO);
    }
}
