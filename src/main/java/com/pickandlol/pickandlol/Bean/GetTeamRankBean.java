package com.pickandlol.pickandlol.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pickandlol.pickandlol.Bean.Small.GetTeamsDAOBean;
import com.pickandlol.pickandlol.Model.DTO.ResponseTeamGetDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import com.pickandlol.pickandlol.Model.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GetTeamRankBean {

    ObjectMapper objectMapper = new ObjectMapper();
    GetTeamsDAOBean getTeamsDAOBean;

    @Autowired
    public GetTeamRankBean(GetTeamsDAOBean getTeamsDAOBean) {
        this.getTeamsDAOBean = getTeamsDAOBean;
    }

    public List<ResponseTeamGetDTO> exec() throws JsonProcessingException {
        List<TeamDAO> teamDAOS = getTeamsDAOBean.exec();

        List<ResponseTeamGetDTO> responseTeamGetDTOList = new ArrayList<>();

        for (TeamDAO teamDAO : teamDAOS) {
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
            responseTeamGetDTOList.add(ResponseTeamGetDTO.builder()
                    .data(data)
                    .oauthId(teamDAO.getOauthId())
                    .canChange(teamDAO.isCanChange())
                    .build());
        }

        return responseTeamGetDTOList;
    }
}
