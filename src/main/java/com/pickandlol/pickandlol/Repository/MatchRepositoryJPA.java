package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MatchDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepositoryJPA extends JpaRepository<MatchDAO, Long> {

    List<MatchDAO> findAllByOrderByMonthAscDayAsc();
}
