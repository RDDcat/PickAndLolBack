package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetMemberDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveMemberDAOBean;
import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.RequestMemberDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteMemberBean {

    GetMemberDAOBean getMemberDAOBean;
    SaveMemberDAOBean saveMemberDAOBean;

    @Autowired
    public DeleteMemberBean(GetMemberDAOBean getMemberDAOBean, SaveMemberDAOBean saveMemberDAOBean) {
        this.getMemberDAOBean = getMemberDAOBean;
        this.saveMemberDAOBean = saveMemberDAOBean;
    }

    // 맴버 삭제
    public String exec(RequestMemberDeleteDTO requestMemberDeleteDTO) {

        // 맴버 찾기
        Member member = getMemberDAOBean.exec(requestMemberDeleteDTO.getOauthId());
        if (member == null) return "fail";

        // 맴버 삭제
        member.delete();

        // 맴버 저장
        saveMemberDAOBean.exec(member);

        return "success";
    }
}
