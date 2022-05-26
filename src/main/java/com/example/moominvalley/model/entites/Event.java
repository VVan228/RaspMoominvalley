package com.example.moominvalley.model.entites;

import com.example.moominvalley.model.embeddables.Audience;
import com.example.moominvalley.model.embeddables.Group;
import com.example.moominvalley.model.embeddables.Subject;
import com.example.moominvalley.model.embeddables.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-mm")
    private LocalDate data;

    private int pair;

    private String description;

    LocalDate week_begining;

    @ElementCollection
    private List<Group> groups;

    @Embedded
    private Subject discipline;

    @ElementCollection
    private List<Teacher>teachers;

    @ElementCollection
    private List<Audience>auditories;

    private int type;

    @ElementCollection
    private List<Integer> related_queries = new ArrayList<>();

    private int affected_schedule_id;
}
