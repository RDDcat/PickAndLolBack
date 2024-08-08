package com.pickandlol.pickandlol.Bean.Small;

import com.pickandlol.pickandlol.Model.DAO.MatchDAO;
import com.pickandlol.pickandlol.Repository.MatchRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMatchsOrderByDateDAOBean {

    MatchRepositoryJPA matchRepositoryJPA;

    @Autowired
    public GetMatchsOrderByDateDAOBean(MatchRepositoryJPA matchRepositoryJPA){
        this.matchRepositoryJPA = matchRepositoryJPA;
    }

    //
    public List<MatchDAO> exec() {
        return matchRepositoryJPA.findAllByOrderByMonthAscDayAsc();
    }
}
