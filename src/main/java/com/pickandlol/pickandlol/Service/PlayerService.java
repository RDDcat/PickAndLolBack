package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetPlayersBean;
import com.pickandlol.pickandlol.Bean.SavePlayerVPLogsBean;
import com.pickandlol.pickandlol.Model.DTO.ResponsePlayerGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    GetPlayersBean getPlayersBean;
    SavePlayerVPLogsBean savePlayerVPLogsBean;

    @Autowired
    public PlayerService(GetPlayersBean getPlayersBean, SavePlayerVPLogsBean savePlayerVPLogsBean) {
        this.getPlayersBean = getPlayersBean;
        this.savePlayerVPLogsBean = savePlayerVPLogsBean;
    }

    public List<ResponsePlayerGetDTO> getPlayers(){
        return getPlayersBean.exec();
    }

    public String savePlayerVPLogs(){
        return savePlayerVPLogsBean.exec();
    }
}
