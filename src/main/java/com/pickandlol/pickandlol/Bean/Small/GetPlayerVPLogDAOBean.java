package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import com.pickandlol.pickandlol.Repository.PlayerVPLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPlayerVPLogDAOBean {

    PlayerVPLogRepositoryJPA playerVPLogRepositoryJPA;

    @Autowired
    public GetPlayerVPLogDAOBean(PlayerVPLogRepositoryJPA playerVPLogRepositoryJPA) {
        this.playerVPLogRepositoryJPA = playerVPLogRepositoryJPA;
    }

    // 가장 최근 플레이어 VP 로그 조회
    public PlayerVPLog exec(String playerId) {
        return playerVPLogRepositoryJPA.findTop1ByPlayerIdOrderByVpUpdateDateDesc(playerId);
    }
}
