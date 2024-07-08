package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.SaveTeamStatisticBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamStatisticService {

    SaveTeamStatisticBean saveTeamStatisticBean;

    @Autowired
    public TeamStatisticService(SaveTeamStatisticBean saveTeamStatisticBean){
        this.saveTeamStatisticBean = saveTeamStatisticBean;
    }

    public void saveTeamStatistic(){
        saveTeamStatisticBean.exec();
    }
}
