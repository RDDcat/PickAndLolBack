package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.RequestClubLogSaveDTO;
import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SaveClubLogBean {

    CreateClubLogDAOBean createClubLogDAOBean;
    SaveClubLogDAOBean saveClubLogDAOBean;
    GetClubDAOBean getClubDAOBean;
    GetClubLogsDAOBean getClubLogsDAOBean;
    UpdateClubDAOBean updateClubDAOBean;
    SaveClubDAOBean saveClubDAOBean;
    GetClubLogsByMatchIdDAOBean getClubLogsByMatchIdDAOBean;
    GetMatchDAOBean getMatchDAOBean;
    UpdateMatchDAOBean updateMatchDAOBean;

    @Autowired
    public SaveClubLogBean(CreateClubLogDAOBean createClubLogDAOBean, SaveClubLogDAOBean saveClubLogDAOBean, GetClubDAOBean getClubDAOBean, GetClubLogsDAOBean getClubLogsDAOBean, UpdateClubDAOBean updateClubDAOBean, SaveClubDAOBean saveClubDAOBean, GetClubLogsByMatchIdDAOBean getClubLogsByMatchIdDAOBean, GetMatchDAOBean getMatchDAOBean, UpdateMatchDAOBean updateMatchDAOBean) {
        this.createClubLogDAOBean = createClubLogDAOBean;
        this.saveClubLogDAOBean = saveClubLogDAOBean;
        this.getClubDAOBean = getClubDAOBean;
        this.getClubLogsDAOBean = getClubLogsDAOBean;
        this.updateClubDAOBean = updateClubDAOBean;
        this.saveClubDAOBean = saveClubDAOBean;
        this.getClubLogsByMatchIdDAOBean = getClubLogsByMatchIdDAOBean;
        this.getMatchDAOBean = getMatchDAOBean;
        this.updateMatchDAOBean = updateMatchDAOBean;
    }

    // 경기 - 팀 정보 저장
    @Transactional
    public Long saveMatchTeam(RequestClubLogSaveDTO requestClubLogSaveDTO) {

        ClubLog clubLog = createClubLogDAOBean.exec(requestClubLogSaveDTO);

        saveClubLogDAOBean.exec(clubLog);

        // 매치 정보 업데이트
        List<ClubLog> clubLogList = getClubLogsByMatchIdDAOBean.exec(requestClubLogSaveDTO.getMatchId());
        MatchDAO matchDAO = getMatchDAOBean.exec(clubLog.getMatchId());
        updateMatchDAOBean.exec(matchDAO, clubLogList);

        // 팀 정보 업데이트
        ClubDAO clubDAO = getClubDAOBean.exec(requestClubLogSaveDTO.getClubId());
        List<ClubLog> clubLogs = getClubLogsDAOBean.exec(requestClubLogSaveDTO.getClubId());
        updateClubDAOBean.exec(clubDAO, clubLogs);

        // 팀 매치 승/패 저장
        if (matchDAO.getWinnerClubId()!=null){
            updateClubDAOBean.exec(matchDAO);
        }

        return clubLog.getClubLogId();
    }

}
