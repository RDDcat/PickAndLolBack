package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MatchDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepositoryJPA extends JpaRepository<MatchDAO, Long> {
}
