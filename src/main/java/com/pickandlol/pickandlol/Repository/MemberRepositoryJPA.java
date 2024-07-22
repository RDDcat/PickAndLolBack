package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepositoryJPA extends JpaRepository<Member, Long> {
    Member findByOauthId(String oauthId);
}