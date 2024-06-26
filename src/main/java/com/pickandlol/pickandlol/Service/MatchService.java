package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.SaveMatchPlayerBean;
import com.pickandlol.pickandlol.Bean.SaveMatchClubBean;
import com.pickandlol.pickandlol.Model.RequestMatchPlayerSaveDTO;
import com.pickandlol.pickandlol.Model.RequestMatchClubSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    SaveMatchClubBean saveMatchClubBean;
    SaveMatchPlayerBean saveMatchPlayerBean;

    @Autowired
    public MatchService(SaveMatchClubBean saveMatchClubBean, SaveMatchPlayerBean saveMatchPlayerBean) {
        this.saveMatchClubBean = saveMatchClubBean;
        this.saveMatchPlayerBean = saveMatchPlayerBean;
    }

    // 경기 - 팀 정보 저장
    public Long saveMatchTeam(RequestMatchClubSaveDTO requestMatchClubSaveDTO) {
        return saveMatchClubBean.saveMatchTeam(requestMatchClubSaveDTO);
    }

    // 경기 - 선수 정보 저장
    public Long saveMatchPlayer(RequestMatchPlayerSaveDTO requestMatchPlayerSaveDTO) {
        return saveMatchPlayerBean.saveMatchPlayer(requestMatchPlayerSaveDTO);
    }
}
