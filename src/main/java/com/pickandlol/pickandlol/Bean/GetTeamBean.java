package com.pickandlol.pickandlol.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pickandlol.pickandlol.Bean.Small.GetTeamByOauthIdDAOBean;
import com.pickandlol.pickandlol.Model.DTO.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import com.pickandlol.pickandlol.Model.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetTeamBean {

    ObjectMapper objectMapper = new ObjectMapper();
    GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean;

    @Autowired
    public GetTeamBean(GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean) {
        this.getTeamByOauthIdDAOBean = getTeamByOauthIdDAOBean;
    }

    public ResponseTeamGetDTO exec(String oauthId) throws JsonProcessingException {

        TeamDAO teamDAO = getTeamByOauthIdDAOBean.exec(oauthId);
        if (teamDAO == null) return null;

        Map<String, PlayerDTO> stringPlayerDTOMap = new HashMap<>();

        try {
            // JSON 문자열을 Map<String, PlayerDTO>로 변환
            stringPlayerDTOMap = objectMapper.readValue(teamDAO.getPlayers(), new TypeReference<Map<String, PlayerDTO>>() {});

            // 변환된 Map 사용
            System.out.println(stringPlayerDTOMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("name", teamDAO.getName());
        dataMap.put("totalVP", teamDAO.getTotalVP());
        dataMap.put("team", teamDAO.getTeamName());
        dataMap.put("teamLogo", teamDAO.getTeamLogo());
        dataMap.put("totalStat", teamDAO.getTotalStat());
        dataMap.put("weekStat", teamDAO.getWeekStat());
        dataMap.put("players", stringPlayerDTOMap);

        String data = objectMapper.writeValueAsString(dataMap);
        return ResponseTeamGetDTO.builder()
                .data(data)
                .oauthId(teamDAO.getOauthId())
                .canChange(teamDAO.isCanChange())
                .build();
    }
}
