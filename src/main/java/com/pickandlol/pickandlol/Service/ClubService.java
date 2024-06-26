package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetClubsBean;
import com.pickandlol.pickandlol.Model.ResponseClubGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    GetClubsBean getClubsBean;

    @Autowired
    public ClubService(GetClubsBean getClubsBean){
        this.getClubsBean = getClubsBean;
    }

    // 팀 전체 조회
    public List<ResponseClubGetDTO> getTeams(){
        return getClubsBean.exec();
    }
}
