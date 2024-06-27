package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateUniqueIdBean;
import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.RequestMatchSaveDTO;
import com.pickandlol.pickandlol.Repository.MatchRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveMatchBean {

    MatchRepositoryJPA matchRepositoryJPA;
    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public SaveMatchBean(CreateUniqueIdBean createUniqueIdBean, MatchRepositoryJPA matchRepositoryJPA) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.matchRepositoryJPA = matchRepositoryJPA;
    }

    public MatchDAO exec(RequestMatchSaveDTO requestMatchSaveDTO) {

        MatchDAO matchDAO = MatchDAO.builder()
                .matchId(createUniqueIdBean.exec())
                .matchType(requestMatchSaveDTO.getMatchType())
                .matchNum(requestMatchSaveDTO.getMatchNum())
                .build();

        matchRepositoryJPA.save(matchDAO);

        return matchDAO;
    }
}
