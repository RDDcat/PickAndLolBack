package com.pickandlol.pickandlol.Bean.Small;


import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import com.pickandlol.pickandlol.Others.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePlayerVPLogsBean {

    TimeFormatter timeFormatter;

    @Autowired
    public CreatePlayerVPLogsBean(TimeFormatter timeFormatter) {
        this.timeFormatter = timeFormatter;
    }

    public PlayerVPLog exec(Integer vpUpdateDate, PlayerDAO playerDAO){
        return PlayerVPLog.builder()
                .playerId(playerDAO.getPlayerId())
                .vp(playerDAO.getVp())
                .vpUpdateDate(vpUpdateDate)
                .build();
    }

    public List<PlayerVPLog> exec(List<PlayerDAO> playerDAOList){

        Integer vpUpdateDate = timeFormatter.exec(LocalDateTime.now());

        List<PlayerVPLog> playerVPLogList = new ArrayList<>();

        for (PlayerDAO playerDAO : playerDAOList) {
            playerVPLogList.add(exec(vpUpdateDate, playerDAO));
        }

        // index 용도
        playerVPLogList.add(PlayerVPLog.builder()
                .playerId("0")
                .vp(0)
                .vpUpdateDate(vpUpdateDate)
                .build());

        return playerVPLogList;
    }
}
