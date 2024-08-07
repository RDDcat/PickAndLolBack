package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.DAO.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
import com.pickandlol.pickandlol.Model.DAO.MatchDAO;
import com.pickandlol.pickandlol.Model.DTO.RequestClubLogSaveDTO;
import com.pickandlol.pickandlol.Model.DAO.ClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
    SaveTeamStatisticBean saveTeamStatisticBean;

    @Autowired
    public SaveClubLogBean(CreateClubLogDAOBean createClubLogDAOBean, UpdateClubLogRelatvieDAOBean updateClubLogRelatvieDAOBean, SaveClubLogDAOBean saveClubLogDAOBean, GetClubDAOBean getClubDAOBean, GetClubLogsDAOBean getClubLogsDAOBean, UpdateClubDAOBean updateClubDAOBean, GetClubLogsByMatchIdDAOBean getClubLogsByMatchIdDAOBean, GetMatchDAOBean getMatchDAOBean, UpdateMatchDAOBean updateMatchDAOBean, SaveTeamStatisticBean saveTeamStatisticBean) {
        this.createClubLogDAOBean = createClubLogDAOBean;
        this.updateClubLogRelatvieDAOBean = updateClubLogRelatvieDAOBean;
        this.saveClubLogDAOBean = saveClubLogDAOBean;
        this.getClubDAOBean = getClubDAOBean;
        this.getClubLogsDAOBean = getClubLogsDAOBean;
        this.updateClubDAOBean = updateClubDAOBean;
        this.getClubLogsByMatchIdDAOBean = getClubLogsByMatchIdDAOBean;
        this.getMatchDAOBean = getMatchDAOBean;
        this.updateMatchDAOBean = updateMatchDAOBean;
        this.saveTeamStatisticBean = saveTeamStatisticBean;
    }

    // 경기 - 팀 정보 저장
    @Transactional
    public String saveMatchTeam(RequestClubLogSaveDTO requestClubLogSaveDTO) {

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
        if (!Objects.equals(matchDAO.getWinnerClubId(), "0")){
            updateClubDAOBean.exec(matchDAO);
        }

        // 매치 상태가 END 일때
        if (matchDAO.getMatchStatus().equals(MatchStatus.END)){
            // 통계 정보 업데이트
            saveTeamStatisticBean.exec();
        }

        return clubLog.getClubLogId();
    }

}
