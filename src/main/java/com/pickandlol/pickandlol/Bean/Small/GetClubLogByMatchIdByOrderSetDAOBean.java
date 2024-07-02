package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.ClubLog;
import com.pickandlol.pickandlol.Model.Enum.OrderSet;
import com.pickandlol.pickandlol.Repository.ClubLogRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClubLogByMatchIdByOrderSetDAOBean {

    ClubLogRepositoryJPA clubLogRepositoryJPA;

    @Autowired
    public GetClubLogByMatchIdByOrderSetDAOBean(ClubLogRepositoryJPA clubLogRepositoryJPA){
        this.clubLogRepositoryJPA = clubLogRepositoryJPA;
    }

    public List<ClubLog> exec(Long matchId, OrderSet orderSet){
        return clubLogRepositoryJPA.findByMatchIdAndOrderSet(matchId, orderSet);
    }
}
