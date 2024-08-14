package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateTeamDAOBean {

    public void exec(Boolean canChange, String players, TeamDAO teamDAO, Map<String, Object> map){
        teamDAO.setName((String) map.get("name"));
        teamDAO.setTotalStat((int) map.get("totalStat"));
        teamDAO.setTeamName((String) map.get("team"));
        teamDAO.setTotalVP((int) map.get("totalVP"));
        teamDAO.setTeamLogo((String) map.get("teamLogo"));
        teamDAO.setWeekStat((int) map.get("weekStat"));
        teamDAO.setAllowd((boolean) map.get("allowed"));
        teamDAO.setPlayers(players);
        teamDAO.setCanChange(canChange);
    }
}
