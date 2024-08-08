package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.*;
import com.pickandlol.pickandlol.Model.DAO.TeamLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SaveTeamStatisticBean {

    GetTeamLogsDAOBean getTeamLogsDAOBean;
    CreateTeamStatisticDTOBean createTeamStatisticDTOBean;
    CalculateTeamStatisticDAOBean calculateTeamStatisticDAOBean;

    @Autowired
    public SaveTeamStatisticBean(GetTeamLogsDAOBean getTeamLogsDAOBean, CreateTeamStatisticDTOBean createTeamStatisticDTOBean, CalculateTeamStatisticDAOBean calculateTeamStatisticDAOBean){
        this.getTeamLogsDAOBean = getTeamLogsDAOBean;
        this.createTeamStatisticDTOBean = createTeamStatisticDTOBean;
        this.calculateTeamStatisticDAOBean = calculateTeamStatisticDAOBean;
    }

    public void exec(){

        // 팀 로그 전체 가져오기
        List<TeamLog> teamLogs = getTeamLogsDAOBean.exec();

        // 결과를 저장할 Map
        Map<String, Map<String, Map<String, Integer>>> resultMap = new HashMap<>();

        // 반복문 돌려서 전체 다 돌려
        for (TeamLog teamLog : teamLogs){

            // 계산
            Map<String, Map<String, Map<String, Integer>>> dataInfo = calculateTeamStatisticDAOBean.exec(teamLog, resultMap);

            // 바꿔야함 이거 잘못됨
            createTeamStatisticDTOBean.exec(dataInfo);
        }

    }
}
