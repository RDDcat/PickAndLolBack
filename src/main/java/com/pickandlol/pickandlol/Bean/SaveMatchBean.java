package com.pickandlol.pickandlol.Bean;

import com.pickandlol.pickandlol.Bean.Small.CreateUniqueIdBean;
import com.pickandlol.pickandlol.Model.Enum.MatchSeason;
import com.pickandlol.pickandlol.Model.Enum.MatchStatus;
import com.pickandlol.pickandlol.Model.MatchDAO;
import com.pickandlol.pickandlol.Model.RequestMatchSaveDTO;
import com.pickandlol.pickandlol.Repository.MatchRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

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

        Integer year = requestMatchSaveDTO.getYear();
        Integer month = requestMatchSaveDTO.getMonth();
        Integer day = requestMatchSaveDTO.getDay();

        // LocalDate 객체 생성
        LocalDate date = LocalDate.of(year, month, day);
        // 요일 계산
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        // 요일 출력 (한국어로)
        String dayOfWeekInKorean = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);

        MatchDAO matchDAO = MatchDAO.builder()
                .matchId(createUniqueIdBean.exec())
                .matchSeason(MatchSeason.valueOf(requestMatchSaveDTO.getMatchSeason()))
                .matchNum(requestMatchSaveDTO.getMatchNum())
                .homeClubId(requestMatchSaveDTO.getHomeClubId())
                .awayClubId(requestMatchSaveDTO.getAwayClubId())
                .stadium(requestMatchSaveDTO.getStadium())
                .year(year)
                .month(month)
                .day(day)
                .dayOfTheWeek(dayOfWeekInKorean)
                .time(requestMatchSaveDTO.getTime())
                .round(requestMatchSaveDTO.getRound())
                .homeScore(0)
                .awayScore(0)
                .matchStatus(MatchStatus.READY)
                .winnerClubId(0L)
                .loserClubId(0L)
                .clubLogId("[]")
                .build();

        matchRepositoryJPA.save(matchDAO);

        return matchDAO;
    }
}
