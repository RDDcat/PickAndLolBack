package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.ClubDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepositoryJPA extends JpaRepository<ClubDAO, String> {

    List<ClubDAO> findAllByOrderByWinCountDescTotalGapDesc();
}
