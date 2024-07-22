package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Repository.MemberRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMemberDAOBean {

    MemberRepositoryJPA memberRepositoryJPA;

    @Autowired
    public SaveMemberDAOBean(MemberRepositoryJPA memberRepositoryJPA) {
        this.memberRepositoryJPA = memberRepositoryJPA;
    }

    // 맴버 저장
    public void exec(Member member) {
        memberRepositoryJPA.save(member);
    }
}
