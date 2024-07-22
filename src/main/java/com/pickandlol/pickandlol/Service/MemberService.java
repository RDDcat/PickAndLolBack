package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.DeleteMemberBean;
import com.pickandlol.pickandlol.Bean.UpdateMemberNameBean;
import com.pickandlol.pickandlol.Bean.UpdateUserImageBean;
import com.pickandlol.pickandlol.Model.RequestMemberDeleteDTO;
import com.pickandlol.pickandlol.Model.RequestMemberImageUpdateDTO;
import com.pickandlol.pickandlol.Model.RequestMemberNameUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    UpdateMemberNameBean updateMemberNameBean;
    UpdateUserImageBean updateUserImageBean;
    DeleteMemberBean deleteMemberBean;

    @Autowired
    public MemberService(UpdateMemberNameBean updateMemberNameBean, UpdateUserImageBean updateUserImageBean, DeleteMemberBean deleteMemberBean) {
        this.updateMemberNameBean = updateMemberNameBean;
        this.updateUserImageBean = updateUserImageBean;
        this.deleteMemberBean = deleteMemberBean;
    }

    // 맴버 이름 변경
    public String updateMemberName(RequestMemberNameUpdateDTO requestMemberNameUpdateDTO) {
        return updateMemberNameBean.exec(requestMemberNameUpdateDTO);
    }

    // 맴버 이미지 변경
    public String updateUserImage(RequestMemberImageUpdateDTO requestMemberImageUpdateDTO) {
        return updateUserImageBean.exec(requestMemberImageUpdateDTO);
    }

    // 맴버 삭제
    public String deleteMember(RequestMemberDeleteDTO requestMemberDeleteDTO) {
        return deleteMemberBean.exec(requestMemberDeleteDTO);
    }
}
