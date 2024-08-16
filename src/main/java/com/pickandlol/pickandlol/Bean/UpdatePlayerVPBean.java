package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.GetPlayerDAOBean;
import com.pickandlol.pickandlol.Bean.Small.SavePlayerDAOBean;
import com.pickandlol.pickandlol.Model.DAO.PlayerDAO;
import com.pickandlol.pickandlol.Model.DTO.RequestPlayerVPUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePlayerVPBean {

    GetPlayerDAOBean getPlayerDAOBean;
    SavePlayerDAOBean savePlayerDAOBean;

    @Autowired
    public UpdatePlayerVPBean(GetPlayerDAOBean getPlayerDAOBean, SavePlayerDAOBean savePlayerDAOBean) {
        this.getPlayerDAOBean = getPlayerDAOBean;
        this.savePlayerDAOBean = savePlayerDAOBean;
    }

    public String exec(RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO) {

        PlayerDAO playerDAO = getPlayerDAOBean.exec(requestPlayerVPUpdateDTO.getPlayerId());
        if (playerDAO == null) return null;

        playerDAO.setVp(requestPlayerVPUpdateDTO.getVp());

        savePlayerDAOBean.exec(playerDAO);

        return playerDAO.getPlayerId();
    }
}
