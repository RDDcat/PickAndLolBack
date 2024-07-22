package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.UpdateMemberNameBean;
import com.pickandlol.pickandlol.Model.RequestMemberNameUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    UpdateMemberNameBean updateMemberNameBean;

    @Autowired
    public MemberService(UpdateMemberNameBean updateMemberNameBean) {
        this.updateMemberNameBean = updateMemberNameBean;
    }

    // 맴버 이름 변경
    public String updateMemberName(RequestMemberNameUpdateDTO requestMemberNameUpdateDTO) {
        return updateMemberNameBean.exec(requestMemberNameUpdateDTO);
    }
}
