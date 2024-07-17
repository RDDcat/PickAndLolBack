package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.*;
import com.pickandlol.pickandlol.Model.RequestTeamLogSaveDTO;
import com.pickandlol.pickandlol.Model.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    GetTeamBean getTeamBean;
    SaveTeamBean saveTeamBean;
    SaveTeamLogBean saveTeamLogBean;
    GetTeamRankBean getTeamRankBean;
    UpdateTeamCanChangeBean updateTeamCanChangeBean;
    UpdateTeamCanChangeImpossibleBean updateTeamCanChangeImpossibleBean;

    @Autowired
    public TeamService(GetTeamBean getTeamBean, SaveTeamBean saveTeamBean, SaveTeamLogBean saveTeamLogBean, GetTeamRankBean getTeamRankBean, UpdateTeamCanChangeBean updateTeamCanChangeBean, UpdateTeamCanChangeImpossibleBean updateTeamCanChangeImpossibleBean){
        this.getTeamBean = getTeamBean;
        this.saveTeamBean = saveTeamBean;
        this.saveTeamLogBean = saveTeamLogBean;
        this.getTeamRankBean = getTeamRankBean;
        this.updateTeamCanChangeBean = updateTeamCanChangeBean;
        this.updateTeamCanChangeImpossibleBean = updateTeamCanChangeImpossibleBean;
    }

    // 팀 정보 조회
    public ResponseTeamGetDTO getTeam(String oauthId){
        return getTeamBean.exec(oauthId);
    }

    // 팀 정보 저장
    public String saveTeam(RequestTeamSaveDTO requestTeamSaveDTO){
        return saveTeamBean.exec(requestTeamSaveDTO);
    }

    // 팀 로그 저장
    public String saveTeamLog(RequestTeamLogSaveDTO requestTeamLogSaveDTO){
        return saveTeamLogBean.exec(requestTeamLogSaveDTO);
    }

    // 랭킹 조회
    public List<ResponseTeamGetDTO> getRank(){
        return getTeamRankBean.exec();
    }

    // 팀 변동 가능 전체 수정
    public boolean updateTeamCanChange(){
        return updateTeamCanChangeBean.exec();
    }

    // 팀 변동 가능 전체 수정
    public boolean updateTeamCanChangeImpossible(){
        return updateTeamCanChangeImpossibleBean.exec();
    }
}
