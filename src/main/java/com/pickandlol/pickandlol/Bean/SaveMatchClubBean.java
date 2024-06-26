package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.MatchClubDAO;
import com.pickandlol.pickandlol.Model.RequestMatchClubSaveDTO;
import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveMatchClubBean {

    CreateMatchClubDAOBean createMatchClubDAOBean;
    SaveMatchClubDAOBean saveMatchClubDAOBean;
    GetClubDAOBean getClubDAOBean;
    GetMatchClubsDAOBean getMatchClubsDAOBean;
    UpdateClubDAOBean updateClubDAOBean;
    SaveClubDAOBean saveClubDAOBean;

    @Autowired
    public SaveMatchClubBean(CreateMatchClubDAOBean createMatchClubDAOBean, SaveMatchClubDAOBean saveMatchClubDAOBean, GetClubDAOBean getClubDAOBean, GetMatchClubsDAOBean getMatchClubsDAOBean, UpdateClubDAOBean updateClubDAOBean, SaveClubDAOBean saveClubDAOBean) {
        this.createMatchClubDAOBean = createMatchClubDAOBean;
        this.saveMatchClubDAOBean = saveMatchClubDAOBean;
        this.getClubDAOBean = getClubDAOBean;
        this.getMatchClubsDAOBean = getMatchClubsDAOBean;
        this.updateClubDAOBean = updateClubDAOBean;
        this.saveClubDAOBean = saveClubDAOBean;
    }

    // 경기 - 팀 정보 저장
    // 매치 추가되는 경우 전체 승/패 추가 예정
    public Long saveMatchTeam(RequestMatchClubSaveDTO requestMatchClubSaveDTO) {

        MatchClubDAO matchClubDAO = createMatchClubDAOBean.exec(requestMatchClubSaveDTO);

        saveMatchClubDAOBean.exec(matchClubDAO);

        // 팀 정보 업데이트
        ClubDAO clubDAO = getClubDAOBean.exec(requestMatchClubSaveDTO.getTeamId());
        List<MatchClubDAO> matchClubDAOS = getMatchClubsDAOBean.exec(requestMatchClubSaveDTO.getTeamId());
        updateClubDAOBean.exec(clubDAO, matchClubDAOS);

        saveClubDAOBean.exec(clubDAO);

        return matchClubDAO.getMatchTeamId();
    }

}
