package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.PlayerVPLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerVPLogRepositoryJPA extends JpaRepository<PlayerVPLog, Long> {

    PlayerVPLog findTop1ByPlayerIdOrderByVpUpdateDateDesc(String playerId);
}
