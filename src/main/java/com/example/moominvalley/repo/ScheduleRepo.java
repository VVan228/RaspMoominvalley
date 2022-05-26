package com.example.moominvalley.repo;

import com.example.moominvalley.model.Day;
import com.example.moominvalley.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ScheduleRepo extends JpaRepository<Day, Integer> {

    @Query("select para from Para as para " +
            "where para.teachers.teacherName= :tN " +
            "and para.day= :day")
    Day getScheduleForDayByTeacher(@Param("tN") String teacherName,
                                   @Param("day") int dayId);
    @Query("select para from Para as para " +
            "where para.auditories.audienceName= :aN " +
            "and para.day= :day")
    Day getScheduleForDayByAudience(@Param("aN") String ayName,
                                    @Param("day") int dayId);

    @Query("select para from Para as para " +
            "where para.groups.groupName= :gN " +
            "and para.day= :day")
    Day getScheduleForDayByGroup(@Param("gN") String groupName,
                                 @Param("day") int dayId);
}
