package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetPlayersBean;
import com.pickandlol.pickandlol.Bean.SavePlayerVPLogsBean;
import com.pickandlol.pickandlol.Bean.UpdatePlayerVPBean;
import com.pickandlol.pickandlol.Bean.UpdatePlayerVPPlusBean;
import com.pickandlol.pickandlol.Model.DTO.RequestPlayerVPUpdateDTO;
import com.pickandlol.pickandlol.Model.DTO.ResponsePlayerGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    GetPlayersBean getPlayersBean;
    SavePlayerVPLogsBean savePlayerVPLogsBean;
    UpdatePlayerVPBean updatePlayerVPBean;
    UpdatePlayerVPPlusBean updatePlayerVPPlusBean;

    @Autowired
    public PlayerService(GetPlayersBean getPlayersBean, SavePlayerVPLogsBean savePlayerVPLogsBean, UpdatePlayerVPBean updatePlayerVPBean, UpdatePlayerVPPlusBean updatePlayerVPPlusBean){
        this.getPlayersBean = getPlayersBean;
        this.savePlayerVPLogsBean = savePlayerVPLogsBean;
        this.updatePlayerVPBean = updatePlayerVPBean;
        this.updatePlayerVPPlusBean = updatePlayerVPPlusBean;
    }

    public List<ResponsePlayerGetDTO> getPlayers(){
        return getPlayersBean.exec();
    }

    public String savePlayerVPLogs(){
        return savePlayerVPLogsBean.exec();
    }

    public String updatePlayerVP(RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO){
        return updatePlayerVPBean.exec(requestPlayerVPUpdateDTO);
    }

    public String updatePlayerVPPlus(RequestPlayerVPUpdateDTO requestPlayerVPUpdateDTO){
        return updatePlayerVPPlusBean.exec(requestPlayerVPUpdateDTO);
    }
}
