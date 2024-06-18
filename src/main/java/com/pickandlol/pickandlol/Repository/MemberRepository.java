package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.Member;
import com.pickandlol.pickandlol.Model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByOauthId(String oauthId);
}
