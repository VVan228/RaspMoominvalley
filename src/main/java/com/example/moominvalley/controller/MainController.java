package com.example.moominvalley.controller;

import com.example.moominvalley.model.embeddables.Audience;
import com.example.moominvalley.model.embeddables.FilterType;
import com.example.moominvalley.model.embeddables.Group;
import com.example.moominvalley.model.embeddables.Teacher;
import com.example.moominvalley.model.entites.Para;
import com.example.moominvalley.repo.ListsRepo;
import com.example.moominvalley.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    ListsRepo listsRepo;
    ScheduleService scheduleService;

    @Autowired
    public MainController(ListsRepo listsRepo, ScheduleService scheduleService) {
        this.listsRepo = listsRepo;
        this.scheduleService = scheduleService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/schedule/byGroup/{group}/{date}"
    )
    public List<List<Para>> getScheduleByGroup(
            @PathVariable String group,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return scheduleService.getWeekScheduleBy(group, date, FilterType.Group);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/schedule/byTeacher/{teacher}/{date}"
    )
    public List<List<Para>> getScheduleByTeacher(
            @PathVariable String teacher,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return scheduleService.getWeekScheduleBy(teacher, date, FilterType.Teacher);
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/schedule/byRoom/{room}/{date}",
            produces = "application/json"
    )
    public List<List<Para>> getScheduleByRoom(
            @PathVariable String room,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return scheduleService.getWeekScheduleBy(room, date, FilterType.Room);
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/groups/getAll"
    )
    public List<Group> getAllGroups(
            Model model
    ){
        return listsRepo.getAllGroups();
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/teachers/getAll"
    )
    public List<Teacher> getAllTeachers(
            Model model
    ){
        return listsRepo.getAllTeachers();
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/rooms/getAll"
    )
    public List<Audience> getAllRooms(
            Model model
    ){
        return listsRepo.getAllAuditories();
    }

}
