package com.pickandlol.pickandlol.Repository;

import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepositoryJPA extends JpaRepository<PlayerDAO, String>{

    List<PlayerDAO> findAllByOrderByStatDesc();
}
