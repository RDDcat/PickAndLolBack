package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateClubDTOBean;
import com.pickandlol.pickandlol.Bean.Small.GetClubsDAOBean;
import com.pickandlol.pickandlol.Model.DTO.ResponseClubGetDTO;
import com.pickandlol.pickandlol.Model.DAO.ClubDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetClubsBean {

    GetClubsDAOBean getClubsDAOBean;
    CreateClubDTOBean createClubDTOBean;

    @Autowired
    public GetClubsBean(GetClubsDAOBean getClubsDAOBean, CreateClubDTOBean createClubDTOBean){
        this.getClubsDAOBean = getClubsDAOBean;
        this.createClubDTOBean = createClubDTOBean;
    }

    public List<ResponseClubGetDTO> exec(){

        List<ClubDAO> clubDAOS = getClubsDAOBean.exec();

        return createClubDTOBean.exec(clubDAOS);
    }
}
