package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MatchPlayerDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchPlayerRepositoryJPA extends JpaRepository<MatchPlayerDAO, Long>{
    List<MatchPlayerDAO> findByPlayerId(Long playerId);
}
