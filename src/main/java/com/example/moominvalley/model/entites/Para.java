package com.example.moominvalley.model.entites;

import com.example.moominvalley.model.embeddables.*;
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
public class Para {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private ClassType type;

    private int day;

    private int pair;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
