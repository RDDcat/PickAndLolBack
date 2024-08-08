package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.Enum.Week;
import com.pickandlol.pickandlol.Model.DAO.TeamStatisticDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamStatisticRepositoryJPA extends JpaRepository<TeamStatisticDAO, String> {
    TeamStatisticDAO findByOauthIdAndWeek(String oauthId, Week week);
}
