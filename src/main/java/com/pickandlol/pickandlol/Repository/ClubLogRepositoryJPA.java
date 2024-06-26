package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.OrderSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubLogRepositoryJPA extends JpaRepository<ClubLog, Long> {

    List<ClubLog> findAllByClubId(Long clubId);

    List<ClubLog> findAllByMatchId(Long matchId);

    List<ClubLog> findByMatchIdAndOrderSet(Long matchId, OrderSet orderSet);
}
