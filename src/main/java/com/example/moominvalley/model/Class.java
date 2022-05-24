package com.example.moominvalley.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    ClassType type;
    int day;
    int pair;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-mm")
    LocalDate week_begining;
    @ElementCollection
    List<Group> groups;
    int subgroup_number;
    Subject discipline;
    @ElementCollection
    List<Teacher>teachers;
    @ElementCollection
    List<Room>auditories;
}
