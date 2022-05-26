package com.example.moominvalley.repo;

import com.example.moominvalley.model.Day;
import com.example.moominvalley.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends JpaRepository<Day, Integer> {

    Day getScheduleForDayByTeacher(int teacherId);
    Day getScheduleForDayByAudience(int audienceId);
    Day getScheduleForDayByGroup(int groupId);
}
