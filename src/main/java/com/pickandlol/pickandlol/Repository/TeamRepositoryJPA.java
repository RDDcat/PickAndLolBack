package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.TeamsDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepositoryJPA extends JpaRepository<TeamsDAO, Long> {

    List<TeamsDAO> findAllByOrderByWinCountDescTotalGapDesc();
}
