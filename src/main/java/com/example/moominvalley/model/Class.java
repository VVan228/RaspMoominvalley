package com.example.moominvalley.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class Class {
    int id;
    ClassType type;
    int day;
    int pair;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-mm")
    LocalDate week_begining;
    List<Group> groups;
    int subgroup_number;
    Subject discipline;
    List<Teacher>teachers;
    List<Room>auditories;
}
