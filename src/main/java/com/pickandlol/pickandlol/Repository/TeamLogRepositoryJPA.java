package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.TeamLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamLogRepositoryJPA extends JpaRepository<TeamLog, Long> {
    TeamLog findTopByUserIdOrderByCreateDateDesc(Long userId);
}
