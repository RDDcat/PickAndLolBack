package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetMemberDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveMemberDAOBean;
import com.pickandlol.pickandlol.Model.DAO.Member;
import com.pickandlol.pickandlol.Model.DTO.RequestMemberNameUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateMemberNameBean {

    GetMemberDAOBean getMemberDAOBean;
    SaveMemberDAOBean saveMemberDAOBean;

    @Autowired
    public UpdateMemberNameBean(GetMemberDAOBean getMemberDAOBean, SaveMemberDAOBean saveMemberDAOBean) {
        this.getMemberDAOBean = getMemberDAOBean;
        this.saveMemberDAOBean = saveMemberDAOBean;
    }

    // 유저 이름 변경
    public String exec(RequestMemberNameUpdateDTO requestMemberNameUpdateDTO) {

        // 맴버 찾기
        Member member = getMemberDAOBean.exec(requestMemberNameUpdateDTO.getOauthId());
        if (member == null) return "fail";

        // 맴버 이름 변경
        member.update(requestMemberNameUpdateDTO.getUserName(), null, null);

        // 맴버 저장
        saveMemberDAOBean.exec(member);

        return "success";
    }
}
