package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
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
    UpdateClubLogRelatvieDAOBean updateClubLogRelatvieDAOBean;
    SaveClubLogDAOBean saveClubLogDAOBean;
    GetClubDAOBean getClubDAOBean;
    GetClubLogsDAOBean getClubLogsDAOBean;
    UpdateClubDAOBean updateClubDAOBean;
    GetClubLogsByMatchIdDAOBean getClubLogsByMatchIdDAOBean;
    GetMatchDAOBean getMatchDAOBean;
    UpdateMatchDAOBean updateMatchDAOBean;

    @Autowired
    public SaveClubLogBean(CreateClubLogDAOBean createClubLogDAOBean, UpdateClubLogRelatvieDAOBean updateClubLogRelatvieDAOBean, SaveClubLogDAOBean saveClubLogDAOBean, GetClubDAOBean getClubDAOBean, GetClubLogsDAOBean getClubLogsDAOBean, UpdateClubDAOBean updateClubDAOBean, GetClubLogsByMatchIdDAOBean getClubLogsByMatchIdDAOBean, GetMatchDAOBean getMatchDAOBean, UpdateMatchDAOBean updateMatchDAOBean) {
        this.createClubLogDAOBean = createClubLogDAOBean;
        this.updateClubLogRelatvieDAOBean = updateClubLogRelatvieDAOBean;
        this.saveClubLogDAOBean = saveClubLogDAOBean;
        this.getClubDAOBean = getClubDAOBean;
        this.getClubLogsDAOBean = getClubLogsDAOBean;
        this.updateClubDAOBean = updateClubDAOBean;
        this.getClubLogsByMatchIdDAOBean = getClubLogsByMatchIdDAOBean;
        this.getMatchDAOBean = getMatchDAOBean;
        this.updateMatchDAOBean = updateMatchDAOBean;
    }

    // 경기 - 팀 정보 저장
    @Transactional
    public Long saveMatchTeam(RequestClubLogSaveDTO requestClubLogSaveDTO) {

        ClubLog clubLog = createClubLogDAOBean.exec(requestClubLogSaveDTO);
        saveClubLogDAOBean.exec(clubLog);

        // ClubLog 전체 오브젝트 관련 정보 수정
        updateClubLogRelatvieDAOBean.exec(clubLog);

        // 매치 정보 업데이트
        List<ClubLog> clubLogList = getClubLogsByMatchIdDAOBean.exec(requestClubLogSaveDTO.getMatchId());
        MatchDAO matchDAO = getMatchDAOBean.exec(clubLog.getMatchId());
        updateMatchDAOBean.exec(matchDAO, clubLogList);

        // 팀 정보 업데이트
        ClubDAO clubDAO = getClubDAOBean.exec(requestClubLogSaveDTO.getClubId());
        List<ClubLog> clubLogs = getClubLogsDAOBean.exec(requestClubLogSaveDTO.getClubId());
        updateClubDAOBean.exec(clubDAO, clubLogs);

        // 팀 매치 승/패 저장
        if (matchDAO.getWinnerClubId()!=0){
            updateClubDAOBean.exec(matchDAO);
        }

        // 매치 상태가 END 일때
        if (matchDAO.getMatchStatus().equals(MatchStatus.END)){
            // 통계 정보 업데이트
        }

        return clubLog.getClubLogId();
    }

}
