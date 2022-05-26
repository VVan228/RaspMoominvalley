package com.example.moominvalley.controller;

import com.example.moominvalley.model.embeddables.Audience;
import com.example.moominvalley.model.embeddables.Group;
import com.example.moominvalley.model.embeddables.Teacher;
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
            value = "/schedule/byGroup/{groupId}/{date}"
    )
    public String getScheduleByGroup(
            @PathVariable int groupId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return "home";
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/schedule/byTeacher/{teacherId}/{date}"
    )
    public String getScheduleByTeacher(
            @PathVariable int teacherId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return "home";
    }

    @ResponseBody
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/schedule/byRoom/{room}/{date}",
            produces = "application/json"
    )
    public String getScheduleByRoom(
            @PathVariable String room,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return "home";
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
