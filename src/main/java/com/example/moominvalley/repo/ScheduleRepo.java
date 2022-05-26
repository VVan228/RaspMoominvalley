package com.example.moominvalley.repo;

import com.example.moominvalley.model.embeddables.Day;
import com.example.moominvalley.model.entites.Para;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Para, Integer> {

    @Query("select para from Para as para " +
            "join para.teachers t where t.teacherName=:tN " +
            "and para.day= :day and para.week_begining=:week")
    List<Para> getScheduleForDayByTeacher(@Param("tN") String teacherName,
                                          @Param("day") int dayId, @Param("week")LocalDate week);
    @Query("select para from Para as para join para.auditories a where a.audienceName=:aN " +
            "and para.day= :day and para.week_begining=:week")
    List<Para> getScheduleForDayByAudience(@Param("aN") String ayName,
                                    @Param("day") int dayId, @Param("week")LocalDate week);

    @Query("select para from Para as para " +
            "join para.groups g where g.groupName= :gN " +
            "and para.day= :day and para.week_begining=:week")
    List<Para> getScheduleForDayByGroup(@Param("gN") String groupName,
                                 @Param("day") int dayId, @Param("week")LocalDate week);
}
