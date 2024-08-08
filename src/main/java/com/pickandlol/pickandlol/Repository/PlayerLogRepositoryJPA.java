package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.DAO.PlayerLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerLogRepositoryJPA extends JpaRepository<PlayerLog, String>{
    List<PlayerLog> findByPlayerId(String playerId);

    List<PlayerLog> findByPlayerIdAndWeek(String playerId, Week week);
}
