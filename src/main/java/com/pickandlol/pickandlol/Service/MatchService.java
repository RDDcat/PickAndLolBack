package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.SaveMatchTeamBean;
import com.pickandlol.pickandlol.Model.RequestMatchTeamSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    SaveMatchTeamBean saveMatchTeamBean;

    @Autowired
    public MatchService(SaveMatchTeamBean saveMatchTeamBean) {
        this.saveMatchTeamBean = saveMatchTeamBean;
    }

    // 경기 - 팀 정보 저장
    public Long saveMatchTeam(RequestMatchTeamSaveDTO requestMatchTeamSaveDTO) {
        return saveMatchTeamBean.saveMatchTeam(requestMatchTeamSaveDTO);
    }

    // 경기 - 선수 정보 저장
}
