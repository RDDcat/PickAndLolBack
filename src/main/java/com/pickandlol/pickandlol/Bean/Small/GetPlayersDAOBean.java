package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import com.pickandlol.pickandlol.Repository.PlayerRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPlayersDAOBean {

    PlayerRepositoryJPA playerRepositoryJPA;

    @Autowired
    public GetPlayersDAOBean(PlayerRepositoryJPA playerRepositoryJPA){
        this.playerRepositoryJPA = playerRepositoryJPA;
    }

    public List<PlayerDAO> exec(String check){
        return playerRepositoryJPA.findAll();
    }

    public List<PlayerDAO> exec(){
        return playerRepositoryJPA.findAllByOrderByStatDesc();
    }
}
