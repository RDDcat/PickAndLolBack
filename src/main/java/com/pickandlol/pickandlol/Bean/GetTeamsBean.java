package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateTeamDTOBean;
import com.pickandlol.pickandlol.Bean.Small.GetTeamsDAOBean;
import com.pickandlol.pickandlol.Model.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.TeamsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTeamsBean {

    GetTeamsDAOBean getTeamsDAOBean;
    CreateTeamDTOBean createTeamDTOBean;

    @Autowired
    public GetTeamsBean(GetTeamsDAOBean getTeamsDAOBean, CreateTeamDTOBean createTeamDTOBean){
        this.getTeamsDAOBean = getTeamsDAOBean;
        this.createTeamDTOBean = createTeamDTOBean;
    }

    public List<ResponseTeamGetDTO> exec(){

        List<TeamsDAO> teamsDAOS = getTeamsDAOBean.exec();

        return createTeamDTOBean.exec(teamsDAOS);
    }
}
