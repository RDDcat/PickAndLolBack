package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.MatchPlayerDAO;
import com.pickandlol.pickandlol.Model.PlayerDAO;
import com.pickandlol.pickandlol.Model.RequestMatchPlayerSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveMatchPlayerBean {

    CreateMatchPlayerDAOBean createMatchPlayerDAOBean;
    GetPlayerDAOBean getPlayerDAOBean;
    GetMatchPlayersDAOBean getMatchPlayersDAOBean;
    UpdatePlayerDAOBean updatePlayerDAOBean;
    SaveMatchPlayerDAOBean saveMatchPlayerDAOBean;
    SavePlayerDAOBean savePlayerDAOBean;

    @Autowired
    public SaveMatchPlayerBean(CreateMatchPlayerDAOBean createMatchPlayerDAOBean, GetPlayerDAOBean getPlayerDAOBean, GetMatchPlayersDAOBean getMatchPlayersDAOBean, UpdatePlayerDAOBean updatePlayerDAOBean, SaveMatchPlayerDAOBean saveMatchPlayerDAOBean, SavePlayerDAOBean savePlayerDAOBean) {
        this.createMatchPlayerDAOBean = createMatchPlayerDAOBean;
        this.getPlayerDAOBean = getPlayerDAOBean;
        this.getMatchPlayersDAOBean = getMatchPlayersDAOBean;
        this.updatePlayerDAOBean = updatePlayerDAOBean;
        this.saveMatchPlayerDAOBean = saveMatchPlayerDAOBean;
        this.savePlayerDAOBean = savePlayerDAOBean;
    }


    // 경기 - 선수 정보 저장
    public Long saveMatchPlayer(RequestMatchPlayerSaveDTO requestMatchPlayerSaveDTO) {

        /*
        * 매치 정보 두개랑 선수 정보 5개씩 10개를 받음
        * 각 선수는 어떤 라인인지, 어떤 매치에 대한 어떤 팀의 데이터인지 알 수 있음
        * 각 정보를 받아서 저장시킴
        * 이때 PlayerDAO를 업데이트 시켜줘야함
        * */

        // 선수 로그 DAO 생성
        MatchPlayerDAO matchPlayerDAO = createMatchPlayerDAOBean.exec(requestMatchPlayerSaveDTO);
        saveMatchPlayerDAOBean.exec(matchPlayerDAO);

        // 선수 정보 업데이트
        PlayerDAO playerDAO = getPlayerDAOBean.exec(requestMatchPlayerSaveDTO.getPlayerId());
        List<MatchPlayerDAO> matchPlayerDAOS = getMatchPlayersDAOBean.exec(requestMatchPlayerSaveDTO.getPlayerId());
        updatePlayerDAOBean.exec(playerDAO, matchPlayerDAOS);

        savePlayerDAOBean.exec(playerDAO);

        return matchPlayerDAO.getMatchClubId();
    }
}
