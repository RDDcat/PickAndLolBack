package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByOauthId(String oauthId);
}
