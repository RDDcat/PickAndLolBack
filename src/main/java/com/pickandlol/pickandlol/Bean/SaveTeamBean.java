package com.pickandlol.pickandlol.Bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import com.pickandlol.pickandlol.Model.DTO.RequestTeamSaveDTO;
import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import com.pickandlol.pickandlol.Model.PlayerDTO;
import com.pickandlol.pickandlol.Others.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SaveTeamBean {

    GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean;
    SaveTeamDAOBean saveTeamDAOBean;
    GetPlayerVPLogDAOBean getPlayerVPLogDAOBean;
    SaveTeamLogDAOBean saveTeamLogDAOBean;
    GetTeamLogDAOBean getTeamLogDAOBean;
    UpdateTeamDAOBean updateTeamDAOBean;
    CreateTeamDAOBean createTeamDAOBean;
    CreateTeamLogDAOBean createTeamLogDAOBean;
    TimeFormatter timeFormatter;

    @Autowired
    public SaveTeamBean(GetTeamByOauthIdDAOBean getTeamByOauthIdDAOBean, SaveTeamDAOBean saveTeamDAOBean, GetPlayerVPLogDAOBean getPlayerVPLogDAOBean, SaveTeamLogDAOBean saveTeamLogDAOBean, GetTeamLogDAOBean getTeamLogDAOBean, UpdateTeamDAOBean updateTeamDAOBean, CreateTeamDAOBean createTeamDAOBean, CreateTeamLogDAOBean createTeamLogDAOBean, TimeFormatter timeFormatter) {
        this.getTeamByOauthIdDAOBean = getTeamByOauthIdDAOBean;
        this.saveTeamDAOBean = saveTeamDAOBean;
        this.getPlayerVPLogDAOBean = getPlayerVPLogDAOBean;
        this.saveTeamLogDAOBean = saveTeamLogDAOBean;
        this.getTeamLogDAOBean = getTeamLogDAOBean;
        this.updateTeamDAOBean = updateTeamDAOBean;
        this.createTeamDAOBean = createTeamDAOBean;
        this.createTeamLogDAOBean = createTeamLogDAOBean;
        this.timeFormatter = timeFormatter;
    }

    private static final String DEFAULT_PLAYER_ID = "0";
    public String exec(RequestTeamSaveDTO requestTeamSaveDTO) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = null;
        Map<String, PlayerDTO> playersMap = null;
        try {
            map = objectMapper.readValue(requestTeamSaveDTO.getData(), new TypeReference<Map<String, Object>>() {});
            playersMap = objectMapper.convertValue(map.get("players"), new TypeReference<Map<String, PlayerDTO>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 팀 선수 목록
        PlayerDTO topPlayer = playersMap.get("top");
        PlayerDTO jglPlayer = playersMap.get("jgl");
        PlayerDTO midPlayer = playersMap.get("mid");
        PlayerDTO adcPlayer = playersMap.get("adc");
        PlayerDTO supPlayer = playersMap.get("sup");

        // 주장 선수 아이디
        String mvpId;
        if (topPlayer.isMvp()) mvpId = topPlayer.getId();
        else if (jglPlayer.isMvp()) mvpId = jglPlayer.getId();
        else if (midPlayer.isMvp()) mvpId = midPlayer.getId();
        else if (adcPlayer.isMvp()) mvpId = adcPlayer.getId();
        else if (supPlayer.isMvp()) mvpId = supPlayer.getId();
        else mvpId = "";

        String players = objectMapper.writeValueAsString(playersMap);

        String createDate = timeFormatter.exec();

        // 선수 vp 마지막 업데이트 날
        PlayerVPLog playerVPLog = getPlayerVPLogDAOBean.exec(DEFAULT_PLAYER_ID);
        if (playerVPLog == null) return null;
        Integer updateDate = playerVPLog.getVpUpdateDate();

        Boolean canChange = requestTeamSaveDTO.isCanChange();

        // 새로운 로그
        TeamLog newTeamLog = createTeamLogDAOBean.exec(createDate, updateDate, requestTeamSaveDTO.getOauthId(), topPlayer.getId(), jglPlayer.getId(), midPlayer.getId(), adcPlayer.getId(), supPlayer.getId(), mvpId);

        // update
        TeamDAO oldTeamDAO = getTeamByOauthIdDAOBean.exec(requestTeamSaveDTO.getOauthId());
        if (oldTeamDAO != null) {
            updateTeamDAOBean.exec(canChange, players, oldTeamDAO, map);

            // 기존 로그 저장
            TeamLog oldTeamLog = getTeamLogDAOBean.exec(requestTeamSaveDTO.getOauthId());
            if (oldTeamLog != null){
                oldTeamLog.setUpdateDate(createDate);
                saveTeamLogDAOBean.exec(oldTeamLog);
            }

            saveTeamLogDAOBean.exec(newTeamLog);
            saveTeamDAOBean.exec(oldTeamDAO);

            return "server update";
        };

        // 팀 새로 생성
        TeamDAO teamDAO = createTeamDAOBean.exec(requestTeamSaveDTO.getOauthId(), mvpId, players, map);

        saveTeamDAOBean.exec(teamDAO);
        saveTeamLogDAOBean.exec(newTeamLog);

        return "server save";
    }
}
