package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetPlayersBean;
import com.pickandlol.pickandlol.Model.ResponsePlayerGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    GetPlayersBean getPlayersBean;

    @Autowired
    public PlayerService(GetPlayersBean getPlayersBean){
        this.getPlayersBean = getPlayersBean;
    }

    public List<ResponsePlayerGetDTO> getPlayers(){
        return getPlayersBean.exec();
    }
}
