package com.pickandlol.pickandlol.Service;

import com.pickandlol.pickandlol.Bean.GetTeamStatisticsBean;
import com.pickandlol.pickandlol.Bean.SaveTeamStatisticBean;
import com.pickandlol.pickandlol.Model.ResponseTeamStatisticGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStatisticService {

    SaveTeamStatisticBean saveTeamStatisticBean;
    GetTeamStatisticsBean getTeamStatisticsBean;

    @Autowired
    public TeamStatisticService(SaveTeamStatisticBean saveTeamStatisticBean, GetTeamStatisticsBean getTeamStatisticsBean){
        this.saveTeamStatisticBean = saveTeamStatisticBean;
        this.getTeamStatisticsBean = getTeamStatisticsBean;
    }

    public void saveTeamStatistic(){
        saveTeamStatisticBean.exec();
    }

    public List<ResponseTeamStatisticGetDTO> getTeamStatistics(){
        return getTeamStatisticsBean.exec();
    }

}
