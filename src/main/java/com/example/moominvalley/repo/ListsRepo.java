package com.example.moominvalley.repo;

import com.example.moominvalley.model.Group;
import com.example.moominvalley.model.Para;
import com.example.moominvalley.model.Audience;
import com.example.moominvalley.model.Teacher;
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
