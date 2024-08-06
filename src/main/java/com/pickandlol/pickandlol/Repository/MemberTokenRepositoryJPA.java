package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.MemberTokenDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTokenRepositoryJPA extends JpaRepository<MemberTokenDAO, Long> {

    MemberTokenDAO findByAccessToken(String accessToken);
}
