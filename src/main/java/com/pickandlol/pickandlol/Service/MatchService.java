package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetMatchsBean;
import com.pickandlol.pickandlol.Bean.SaveMatchBean;
import com.pickandlol.pickandlol.Bean.SavePlayerLogBean;
import com.pickandlol.pickandlol.Bean.SaveClubLogBean;
import com.pickandlol.pickandlol.Model.DAO.MatchDAO;
import com.pickandlol.pickandlol.Model.DTO.RequestClubLogSaveDTO;
import com.pickandlol.pickandlol.Model.DTO.RequestMatchSaveDTO;
import com.pickandlol.pickandlol.Model.DTO.RequestPlayerLogSaveDTO;
import com.pickandlol.pickandlol.Model.DTO.ResponseMatchGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    GetMatchsBean getMatchsBean;
    SaveMatchBean saveMatchBean;
    SaveClubLogBean saveClubLogBean;
    SavePlayerLogBean savePlayerLogBean;

    @Autowired
    public MatchService(GetMatchsBean getMatchsBean, SaveMatchBean saveMatchBean, SaveClubLogBean saveClubLogBean, SavePlayerLogBean savePlayerLogBean) {
        this.getMatchsBean = getMatchsBean;
        this.saveMatchBean = saveMatchBean;
        this.saveClubLogBean = saveClubLogBean;
        this.savePlayerLogBean = savePlayerLogBean;
    }

    // 경기 전체 조회
    public List<ResponseMatchGetDTO> getMatchs() {
        return getMatchsBean.exec();
    }

    // 경기 정보 저장
    public MatchDAO saveMatch(RequestMatchSaveDTO requestMatchSaveDTO) {
        return saveMatchBean.exec(requestMatchSaveDTO);
    }

    // 경기 - 팀 정보 저장
    public String saveMatchTeam(RequestClubLogSaveDTO requestClubLogSaveDTO) {
        return saveClubLogBean.saveMatchTeam(requestClubLogSaveDTO);
    }

    // 경기 - 선수 정보 저장
    public String saveMatchPlayer(RequestPlayerLogSaveDTO requestPlayerLogSaveDTO) {
        return savePlayerLogBean.saveMatchPlayer(requestPlayerLogSaveDTO);
    }
}
