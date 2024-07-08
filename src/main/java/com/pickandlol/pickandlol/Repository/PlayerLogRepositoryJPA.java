package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.PlayerLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerLogRepositoryJPA extends JpaRepository<PlayerLog, Long>{
    List<PlayerLog> findByPlayerId(Long playerId);

    List<PlayerLog> findByPlayerIdAndWeek(Long playerId, Week week);
}
