package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetTeamsBean;
import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    GetTeamsBean getTeamsBean;

    @Autowired
    public TeamService(GetTeamsBean getTeamsBean){
        this.getTeamsBean = getTeamsBean;
    }

    // 팀 전체 조회
    public List<ResponseTeamGetDTO> getTeams(){
        return getTeamsBean.exec();
    }
}
