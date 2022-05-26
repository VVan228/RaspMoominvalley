package com.example.moominvalley.controller;

import com.example.moominvalley.model.entites.Para;
import com.example.moominvalley.repo.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UploadController {

    ScheduleRepo scheduleRepo;

    @Autowired
    UploadController(ScheduleRepo scheduleRepo){
        this.scheduleRepo = scheduleRepo;
    }

    @ResponseBody
    @RequestMapping(value = "/uploadParas",consumes = "application/json",method = RequestMethod.POST)
    public void uploadParas(@RequestBody List<Para> paraList){
        scheduleRepo.saveAll(paraList);
    }

}
