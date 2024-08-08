package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import com.pickandlol.pickandlol.Repository.PlayerVPLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SavePlayerVPLogDAOBean {

    PlayerVPLogRepositoryJPA playerVPLogRepositoryJPA;

    @Autowired
    public SavePlayerVPLogDAOBean(PlayerVPLogRepositoryJPA playerVPLogRepositoryJPA) {
        this.playerVPLogRepositoryJPA = playerVPLogRepositoryJPA;
    }

    // 플레이어 VP 로그 저장
    public void exec(PlayerVPLog playerVPLog) {
        playerVPLogRepositoryJPA.save(playerVPLog);
    }

    // 플레이어 VP 로그 전체 저장
    public void exec(List<PlayerVPLog> playerVPLogs) {
        playerVPLogRepositoryJPA.saveAll(playerVPLogs);
    }
}
