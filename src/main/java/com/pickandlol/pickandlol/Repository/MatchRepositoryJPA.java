package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.MatchDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepositoryJPA extends JpaRepository<MatchDAO, String> {

    List<MatchDAO> findAllByOrderByMonthAscDayAsc();
}
