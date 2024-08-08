package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDAO, Long> {
    UserDAO findByLoginId(String loginId);
}
