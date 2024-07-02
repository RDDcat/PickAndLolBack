package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateMatchDTOBean;
import com.pickandlol.pickandlol.Bean.Small.GetMatchsOrderByDateDAOBean;
import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.ResponseMatchGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatchsBean {

    GetMatchsOrderByDateDAOBean getMatchsOrderByDateDAOBean;
    CreateMatchDTOBean createMatchDTOBean;

    @Autowired
    public GetMatchsBean(GetMatchsOrderByDateDAOBean getMatchsOrderByDateDAOBean, CreateMatchDTOBean createMatchDTOBean) {
        this.getMatchsOrderByDateDAOBean = getMatchsOrderByDateDAOBean;
        this.createMatchDTOBean = createMatchDTOBean;
    }

    // 매치 전체 조회하기
    public List<ResponseMatchGetDTO> exec(){

        // 매치 데이터 날짜순 정렬로 가져오기
        List<MatchDAO> matchDAOS = getMatchsOrderByDateDAOBean.exec();

        // DTO 변환
        return createMatchDTOBean.exec(matchDAOS);

    }
}
