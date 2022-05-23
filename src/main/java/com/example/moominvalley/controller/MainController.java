package com.example.moominvalley.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Controller
public class MainController {

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


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/schedule/byRoom/{roomId}/{date}"
    )
    public String getScheduleByRoom(
            @PathVariable int roomId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
            Model model
    ){
        return "home";
    }


    @RequestMapping(
            method = RequestMethod.GET,
            value = "/groups/getAll"
    )
    public String getAllGroups(
            Model model
    ){
        return "home";
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/teachers/getAll"
    )
    public String getAllTeachers(
            Model model
    ){
        return "home";
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/rooms/getAll"
    )
    public String getAllRooms(
            Model model
    ){
        return "home";
    }

}
