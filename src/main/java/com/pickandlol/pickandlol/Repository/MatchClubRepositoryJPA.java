package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MatchClubDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchClubRepositoryJPA extends JpaRepository<MatchClubDAO, Long> {

    List<MatchClubDAO> findAllByTeamId(Long teamId);
}
