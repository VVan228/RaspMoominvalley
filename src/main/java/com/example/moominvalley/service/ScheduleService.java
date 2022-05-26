package com.example.moominvalley.service;

import com.example.moominvalley.model.embeddables.Day;
import com.example.moominvalley.model.embeddables.FilterType;
import com.example.moominvalley.model.entites.Para;
import com.example.moominvalley.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ScheduleService {

    List<LocalTime> times = new ArrayList<>(List.of(
            LocalTime.of(8, 15),
            LocalTime.of(10, 0),
            LocalTime.of(11, 45),
            LocalTime.of(13, 45),
            LocalTime.of(15, 30),
            LocalTime.of(17, 10),
            LocalTime.of(18, 45),
            LocalTime.of(20, 20)
    ));

    @Autowired
    private ScheduleRepo scheduleRepo;

    public List<List<Para>> getWeekScheduleBy(String name,
                                       LocalDate day,
                                       FilterType filterType){
        //LocalDate now = LocalDate.now();
        /*TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate monday = day.with(fieldISO, 1);
        Period period = Period.between(monday, day);
        System.out.print(period.getDays() + " days");*/
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate monday = day.with(fieldISO, 1);
        List<List<Para>> ans = new ArrayList<>();
        switch (filterType) {
            case Room -> {
                for (int i=1;i<8;i++) {
                    ans.add(scheduleRepo.getScheduleForDayByAudience(name, i, monday));
                }
            }
            case Group -> {
                for (int i=1;i<8;i++) {
                    ans.add(scheduleRepo.getScheduleForDayByGroup(name, i, monday));
                }
            }
            case Teacher -> {
                for (int i=1;i<8;i++) {
                    ans.add(scheduleRepo.getScheduleForDayByTeacher(name, i, monday));
                }
            }
        }

        for(List<Para> pairs: ans){
            for(Para pair: pairs){
                pair.setPairTimed(LocalDateTime.of(pair.getWeek_begining().plusDays(pair.getDay()), times.get(pair.getPair())));
            }
        }

        return ans;
    }
}
