package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePlayerLogBean {

    CreatePlayerLogDAOBean createPlayerLogDAOBean;
    GetPlayerDAOBean getPlayerDAOBean;
    GetPlayerLogsDAOBean getPlayerLogsDAOBean;
    GetClubLogDAOBean getClubLogDAOBean;
    UpdatePlayerDAOBean updatePlayerDAOBean;
    SavePlayerLogDAOBean savePlayerLogDAOBean;
    SavePlayerDAOBean savePlayerDAOBean;
    GetClubDAOBean getClubDAOBean;

    @Autowired
    public SavePlayerLogBean(CreatePlayerLogDAOBean createPlayerLogDAOBean, GetPlayerDAOBean getPlayerDAOBean, GetPlayerLogsDAOBean getPlayerLogsDAOBean, GetClubLogDAOBean getClubLogDAOBean, UpdatePlayerDAOBean updatePlayerDAOBean, SavePlayerLogDAOBean savePlayerLogDAOBean, SavePlayerDAOBean savePlayerDAOBean, GetClubDAOBean getClubDAOBean) {
        this.createPlayerLogDAOBean = createPlayerLogDAOBean;
        this.getPlayerDAOBean = getPlayerDAOBean;
        this.getPlayerLogsDAOBean = getPlayerLogsDAOBean;
        this.getClubLogDAOBean = getClubLogDAOBean;
        this.updatePlayerDAOBean = updatePlayerDAOBean;
        this.savePlayerLogDAOBean = savePlayerLogDAOBean;
        this.savePlayerDAOBean = savePlayerDAOBean;
        this.getClubDAOBean = getClubDAOBean;
    }


    // 경기 - 선수 정보 저장
    public Long saveMatchPlayer(RequestPlayerLogSaveDTO requestPlayerLogSaveDTO) {

        /*
        * 매치 정보 두개랑 선수 정보 5개씩 10개를 받음
        * 각 선수는 어떤 라인인지, 어떤 매치에 대한 어떤 팀의 데이터인지 알 수 있음
        * 각 정보를 받아서 저장시킴
        * 이때 PlayerDAO를 업데이트 시켜줘야함
        * */

        // 선수 로그 DAO 생성
        ClubLog clubLog = getClubLogDAOBean.exec(requestPlayerLogSaveDTO.getClubLogId());
        PlayerLog playerLog = createPlayerLogDAOBean.exec(clubLog, requestPlayerLogSaveDTO);
        savePlayerLogDAOBean.exec(playerLog);

        // 선수 정보 업데이트
        PlayerDAO playerDAO = getPlayerDAOBean.exec(requestPlayerLogSaveDTO.getPlayerId());
        List<PlayerLog> playerLogs = getPlayerLogsDAOBean.exec(requestPlayerLogSaveDTO.getPlayerId());
        ClubDAO clubDAO = getClubDAOBean.exec(playerDAO.getClubId());
        updatePlayerDAOBean.exec(playerDAO, playerLogs, clubDAO);

        savePlayerDAOBean.exec(playerDAO);

        return playerLog.getPlayerLogId();
    }
}
