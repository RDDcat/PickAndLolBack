package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.TeamDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamDAO, String> {
    TeamDAO findByOauthId(String oauthId);
}
