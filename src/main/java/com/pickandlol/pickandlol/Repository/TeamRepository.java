package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.TeamDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<TeamDAO, Long> {
    TeamDAO findByOauthId(String oauthId);
}
