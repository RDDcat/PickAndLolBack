package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetTeamsDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SaveTeamDAOBean;
import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateTeamCanChangeImpossibleBean {

    GetTeamsDAOBean getTeamsDAOBean;
    SaveTeamDAOBean saveTeamDAOBean;

    @Autowired
    public UpdateTeamCanChangeImpossibleBean(GetTeamsDAOBean getTeamsDAOBean, SaveTeamDAOBean saveTeamDAOBean) {
        this.getTeamsDAOBean = getTeamsDAOBean;
        this.saveTeamDAOBean = saveTeamDAOBean;
    }

    public boolean exec() {

        List<TeamDAO> teamDAOList = getTeamsDAOBean.exec();

        for(TeamDAO teamDAO : teamDAOList){
            teamDAO.setCanChange(false);
            saveTeamDAOBean.exec(teamDAO);
        }

        return true;
    }
}
