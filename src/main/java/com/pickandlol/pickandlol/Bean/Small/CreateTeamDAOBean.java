package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CreateTeamDAOBean {

    public TeamDAO exec(String oauthId, String mvpId, String players, Map<String, Object> map){
        return TeamDAO.builder()
                .name((String) map.get("name"))
                .totalStat((int) map.get("totalStat"))
                .teamName((String) map.get("team"))
                .totalVP((int) map.get("totalVP"))
                .teamLogo((String) map.get("teamLogo"))
                .weekStat((int) map.get("weekStat"))
                .allowd((boolean) map.get("allowed"))
                .oauthId(oauthId)
                .mvpId(mvpId)
                .players(players)
                .canChange(false)
                .build();
    }
}
