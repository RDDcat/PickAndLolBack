package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchTeamRepositoryJPA extends JpaRepository<MatchTeamDAO, Long> {
}
