package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreatePlayersDTOBean;
import com.pickandlol.pickandlol.Bean.Small.GetPlayersDAOBean;
import com.pickandlol.pickandlol.Model.PlayerDAO;
import com.pickandlol.pickandlol.Model.ResponsePlayerGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPlayersBean {

    GetPlayersDAOBean getPlayersDAOBean;
    CreatePlayersDTOBean createPlayersDTOBean;

    @Autowired
    public GetPlayersBean(GetPlayersDAOBean getPlayersDAOBean, CreatePlayersDTOBean createPlayersDTOBean){
        this.getPlayersDAOBean = getPlayersDAOBean;
        this.createPlayersDTOBean = createPlayersDTOBean;
    }

    public List<ResponsePlayerGetDTO> exec(){

        List<PlayerDAO> playerDAOS = getPlayersDAOBean.exec();

        return createPlayersDTOBean.exec(playerDAOS);
    }
}
