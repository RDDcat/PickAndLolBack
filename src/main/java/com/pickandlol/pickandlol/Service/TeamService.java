package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetTeamBean;
import com.pickandlol.pickandlol.Bean.GetTeamRankBean;
import com.pickandlol.pickandlol.Bean.SaveTeamBean;
import com.pickandlol.pickandlol.Model.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    GetTeamBean getTeamBean;
    SaveTeamBean saveTeamBean;
    GetTeamRankBean getTeamRankBean;

    @Autowired
    public TeamService(GetTeamBean getTeamBean, SaveTeamBean saveTeamBean, GetTeamRankBean getTeamRankBean) {
        this.getTeamBean = getTeamBean;
        this.saveTeamBean = saveTeamBean;
        this.getTeamRankBean = getTeamRankBean;
    }

    // 팀 정보 조회
    public ResponseTeamGetDTO getTeam(String oauthId){
        return getTeamBean.exec(oauthId);
    }

    // 팀 정보 저장
    public String saveTeam(RequestTeamSaveDTO requestTeamSaveDTO){
        return saveTeamBean.exec(requestTeamSaveDTO);
    }

    // 랭킹 조회
    public List<ResponseTeamGetDTO> getRank(){
        return getTeamRankBean.exec();
    }
}
