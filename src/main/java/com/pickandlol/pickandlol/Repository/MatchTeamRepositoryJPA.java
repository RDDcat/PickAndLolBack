package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MatchTeamDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchTeamRepositoryJPA extends JpaRepository<MatchTeamDAO, Long> {

    List<MatchTeamDAO> findAllByTeamId(Long teamId);
}
