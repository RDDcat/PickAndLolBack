package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamLogRepositoryJPA extends JpaRepository<TeamLog, String> {
    TeamLog findTopByOauthIdOrderByCreateDateDesc(String oauthId);
}
