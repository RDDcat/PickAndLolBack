package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import com.pickandlol.pickandlol.Model.RequestMatchTeamSaveDTO;
import com.pickandlol.pickandlol.Model.TeamsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveMatchTeamBean {

    CreateMatchTeamDAOBean createMatchTeamDAOBean;
    SaveMatchTeamDAOBean saveMatchTeamDAOBean;
    GetTeamDAOBean getTeamDAOBean;
    GetMatchTeamsDAOBean getMatchTeamsDAOBean;
    UpdateTeamDAOBean updateTeamDAOBean;
    SaveTeamDAOBean saveTeamDAOBean;

    @Autowired
    public SaveMatchTeamBean(CreateMatchTeamDAOBean createMatchTeamDAOBean, SaveMatchTeamDAOBean saveMatchTeamDAOBean, GetTeamDAOBean getTeamDAOBean, GetMatchTeamsDAOBean getMatchTeamsDAOBean, UpdateTeamDAOBean updateTeamDAOBean, SaveTeamDAOBean saveTeamDAOBean) {
        this.createMatchTeamDAOBean = createMatchTeamDAOBean;
        this.saveMatchTeamDAOBean = saveMatchTeamDAOBean;
        this.getTeamDAOBean = getTeamDAOBean;
        this.getMatchTeamsDAOBean = getMatchTeamsDAOBean;
        this.updateTeamDAOBean = updateTeamDAOBean;
        this.saveTeamDAOBean = saveTeamDAOBean;
    }

    // 경기 - 팀 정보 저장
    // 매치 추가되는 경우 전체 승/패 추가 예정
    public Long saveMatchTeam(RequestMatchTeamSaveDTO requestMatchTeamSaveDTO) {

        MatchTeamDAO matchTeamDAO = createMatchTeamDAOBean.exec(requestMatchTeamSaveDTO);

        saveMatchTeamDAOBean.exec(matchTeamDAO);

        // 팀 정보 업데이트
        TeamsDAO teamsDAO = getTeamDAOBean.exec(requestMatchTeamSaveDTO.getTeamId());
        List<MatchTeamDAO> matchTeamDAOS = getMatchTeamsDAOBean.exec(requestMatchTeamSaveDTO.getTeamId());
        updateTeamDAOBean.exec(teamsDAO, matchTeamDAOS);

        saveTeamDAOBean.exec(teamsDAO);

        return matchTeamDAO.getMatchTeamId();
    }

}
