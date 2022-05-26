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

    @Query("select p.teachers from Para as p")
    List<Teacher> getAllTeachers();

    @Query("select p.groups from Para as p")
    List<Group> getAllGroups();

    @Query("select p.auditories from Para as p")
    List<Audience> getAllAuditories();
}
