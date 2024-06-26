package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.RequestClubLogSaveDTO;
import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveClubLogBean {

    CreateClubLogDAOBean createClubLogDAOBean;
    SaveClubLogDAOBean saveClubLogDAOBean;
    GetClubDAOBean getClubDAOBean;
    GetClubLogsDAOBean getClubLogsDAOBean;
    UpdateClubDAOBean updateClubDAOBean;
    SaveClubDAOBean saveClubDAOBean;

    @Autowired
    public SaveClubLogBean(CreateClubLogDAOBean createClubLogDAOBean, SaveClubLogDAOBean saveClubLogDAOBean, GetClubDAOBean getClubDAOBean, GetClubLogsDAOBean getClubLogsDAOBean, UpdateClubDAOBean updateClubDAOBean, SaveClubDAOBean saveClubDAOBean) {
        this.createClubLogDAOBean = createClubLogDAOBean;
        this.saveClubLogDAOBean = saveClubLogDAOBean;
        this.getClubDAOBean = getClubDAOBean;
        this.getClubLogsDAOBean = getClubLogsDAOBean;
        this.updateClubDAOBean = updateClubDAOBean;
        this.saveClubDAOBean = saveClubDAOBean;
    }

    // 경기 - 팀 정보 저장
    // 매치 추가되는 경우 전체 승/패 추가 예정
    public Long saveMatchTeam(RequestClubLogSaveDTO requestClubLogSaveDTO) {

        ClubLog clubLog = createClubLogDAOBean.exec(requestClubLogSaveDTO);

        saveClubLogDAOBean.exec(clubLog);

        // 팀 정보 업데이트
        ClubDAO clubDAO = getClubDAOBean.exec(requestClubLogSaveDTO.getTeamId());
        List<ClubLog> clubLogs = getClubLogsDAOBean.exec(requestClubLogSaveDTO.getTeamId());
        updateClubDAOBean.exec(clubDAO, clubLogs);

        saveClubDAOBean.exec(clubDAO);

        return clubLog.getMatchTeamId();
    }

}
