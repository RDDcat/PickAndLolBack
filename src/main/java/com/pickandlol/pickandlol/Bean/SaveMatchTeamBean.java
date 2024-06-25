package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateMatchTeamDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveMatchTeamDAOBean;
import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import com.pickandlol.pickandlol.Model.RequestMatchTeamSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMatchTeamBean {

    CreateMatchTeamDAOBean createMatchTeamDAOBean;
    SaveMatchTeamDAOBean saveMatchTeamDAOBean;

    @Autowired
    public SaveMatchTeamBean(CreateMatchTeamDAOBean createMatchTeamDAOBean, SaveMatchTeamDAOBean saveMatchTeamDAOBean) {
        this.createMatchTeamDAOBean = createMatchTeamDAOBean;
        this.saveMatchTeamDAOBean = saveMatchTeamDAOBean;
    }

    // 경기 - 팀 정보 저장
    public Long saveMatchTeam(RequestMatchTeamSaveDTO requestMatchTeamSaveDTO) {

        MatchTeamDAO matchTeamDAO = createMatchTeamDAOBean.exec(requestMatchTeamSaveDTO);

        saveMatchTeamDAOBean.exec(matchTeamDAO);

        return matchTeamDAO.getMatchTeamId();
    }

}
