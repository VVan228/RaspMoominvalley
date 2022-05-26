package com.example.moominvalley.service;

import com.example.moominvalley.model.embeddables.Day;
import com.example.moominvalley.model.embeddables.FilterType;
import com.example.moominvalley.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepo scheduleRepo;

    public List<Day> getWeekScheduleBy(String name,
                                       LocalDate day,
                                       FilterType filterType){
        //LocalDate now = LocalDate.now();
        /*TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate monday = day.with(fieldISO, 1);
        Period period = Period.between(monday, day);
        System.out.print(period.getDays() + " days");*/
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        LocalDate monday = day.with(fieldISO, 1);
        List<Day> ans = new ArrayList<>();
        switch (filterType) {
            case Room -> {
                for (int i=1;i<8;i++) {
                    Day d = new Day();
                    d.setListParas(scheduleRepo.getScheduleForDayByAudience(name, i, monday));
                    ans.add(d);
                }
                return ans;
            }
            case Group -> {
                for (int i=1;i<8;i++) {
                    Day d = new Day();
                    d.setListParas(scheduleRepo.getScheduleForDayByGroup(name, i, monday));
                    ans.add(d);
                }
                return ans;
            }
            case Teacher -> {
                for (int i=1;i<8;i++) {
                    Day d = new Day();
                    d.setListParas(scheduleRepo.getScheduleForDayByTeacher(name, i, monday));
                    ans.add(d);
                }
                return ans;
            }
        }
        return null;
    }
}
