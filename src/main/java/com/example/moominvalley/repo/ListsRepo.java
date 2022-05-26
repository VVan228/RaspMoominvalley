package com.example.moominvalley.repo;

import com.example.moominvalley.model.embeddables.Group;
import com.example.moominvalley.model.entites.Para;
import com.example.moominvalley.model.embeddables.Audience;
import com.example.moominvalley.model.embeddables.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListsRepo extends JpaRepository<Para, Integer> {

    @Query("select distinct t from Para as p join p.teachers t")
    List<Teacher> getAllTeachers();

    @Query("select distinct g from Para as p join p.groups g")
    List<Group> getAllGroups();

    @Query("select distinct a from Para as p join p.auditories a")
    List<Audience> getAllAuditories();
}
