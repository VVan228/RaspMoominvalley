package com.example.moominvalley.service;

import com.example.moominvalley.model.Para;
import com.example.moominvalley.model.FilterType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {

    public List<List<Para>> getWeekScheduleBy(int id, LocalDate day, FilterType filterType){
        return null;
    }

}
