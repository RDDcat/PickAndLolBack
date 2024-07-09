package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.TeamStatisticDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
public class CreateTeamStatisticDTOBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetTeamStatisticDAOBean getTeamStatisticDAOBean;
    SaveTeamStatisticDAOBean saveTeamStatisticDAOBean;

    @Autowired
    public CreateTeamStatisticDTOBean(CreateUniqueIdBean createUniqueIdBean, GetTeamStatisticDAOBean getTeamStatisticDAOBean, SaveTeamStatisticDAOBean saveTeamStatisticDAOBean){
        this.createUniqueIdBean = createUniqueIdBean;
        this.getTeamStatisticDAOBean = getTeamStatisticDAOBean;
        this.saveTeamStatisticDAOBean = saveTeamStatisticDAOBean;
    }

    @Transactional
    public void exec(Map<String, Map<String, Map<String, Integer>>> map){

        for (String oauthId : map.keySet()){
            for (String week : map.get(oauthId).keySet()){
                int total = map.get(oauthId).get(week).get("total");
                TeamStatisticDAO teamStatisticDAO = getTeamStatisticDAOBean.exec(oauthId, Week.valueOf(week));
                if (teamStatisticDAO == null){
                    teamStatisticDAO = new TeamStatisticDAO();
                    teamStatisticDAO.setOauthId(oauthId);
                    teamStatisticDAO.setWeek(Week.valueOf(week));
                    teamStatisticDAO.setScore(total);
                    teamStatisticDAO.setTeamStatisticId(createUniqueIdBean.exec());

                    saveTeamStatisticDAOBean.exec(teamStatisticDAO);

                } else {
                    teamStatisticDAO.setWeek(Week.valueOf(week));
                    teamStatisticDAO.setScore(total);

                    saveTeamStatisticDAOBean.exec(teamStatisticDAO);
                }
            }
        }
    }
}
