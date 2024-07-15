package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.OrderSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubLogRepositoryJPA extends JpaRepository<ClubLog, String> {

    List<ClubLog> findAllByClubId(String clubId);

    List<ClubLog> findAllByMatchId(String matchId);

    List<ClubLog> findByMatchIdAndOrderSet(String matchId, OrderSet orderSet);
}
