package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreatePlayerVPLogsBean;
import com.pickandlol.pickandlol.Bean.Small.GetPlayersDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SavePlayerVPLogDAOBean;
import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePlayerVPLogsBean {

    GetPlayersDAOBean getPlayersDAOBean;
    CreatePlayerVPLogsBean createPlayerVPLogsBean;
    SavePlayerVPLogDAOBean savePlayerVPLogDAOBean;

    @Autowired
    public SavePlayerVPLogsBean(GetPlayersDAOBean getPlayersDAOBean, CreatePlayerVPLogsBean createPlayerVPLogsBean, SavePlayerVPLogDAOBean savePlayerVPLogDAOBean) {
        this.getPlayersDAOBean = getPlayersDAOBean;
        this.createPlayerVPLogsBean = createPlayerVPLogsBean;
        this.savePlayerVPLogDAOBean = savePlayerVPLogDAOBean;
    }

    // 플레이어 VP 로그 전체 저장
    public String exec() {

        // PlayerDAO 전체 가져오기
        List<PlayerDAO> playerDAOList = getPlayersDAOBean.exec("all");
        if (playerDAOList.isEmpty()) return null;

        // 해당 선수 아이디와 vp 가지고 PlayerVPLog 생성
        List<PlayerVPLog> playerVPLogList = createPlayerVPLogsBean.exec(playerDAOList);

        // PlayerVPLog 전체 저장
        savePlayerVPLogDAOBean.exec(playerVPLogList);

        return "success";
    }
}
