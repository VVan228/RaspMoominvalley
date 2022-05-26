package com.example.moominvalley.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "para")
public class Para {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private ClassType type;

    private int day;

    private int pair;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-mm")
    LocalDate week_begining;

    @ElementCollection
    private List<Group> groups;

    private int subgroup_number;

    @Embedded
    private Subject discipline;

    @ElementCollection
    private List<Teacher>teachers;

    @ElementCollection
    private List<Audience>auditories;
}
