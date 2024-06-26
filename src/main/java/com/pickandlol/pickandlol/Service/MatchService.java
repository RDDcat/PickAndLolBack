package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.SavePlayerLogBean;
import com.pickandlol.pickandlol.Bean.SaveClubLogBean;
import com.pickandlol.pickandlol.Model.RequestPlayerLogSaveDTO;
import com.pickandlol.pickandlol.Model.RequestClubLogSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    SaveClubLogBean saveClubLogBean;
    SavePlayerLogBean savePlayerLogBean;

    @Autowired
    public MatchService(SaveClubLogBean saveClubLogBean, SavePlayerLogBean savePlayerLogBean) {
        this.saveClubLogBean = saveClubLogBean;
        this.savePlayerLogBean = savePlayerLogBean;
    }

    // 경기 - 팀 정보 저장
    public Long saveMatchTeam(RequestClubLogSaveDTO requestClubLogSaveDTO) {
        return saveClubLogBean.saveMatchTeam(requestClubLogSaveDTO);
    }

    // 경기 - 선수 정보 저장
    public Long saveMatchPlayer(RequestPlayerLogSaveDTO requestPlayerLogSaveDTO) {
        return savePlayerLogBean.saveMatchPlayer(requestPlayerLogSaveDTO);
    }
}
