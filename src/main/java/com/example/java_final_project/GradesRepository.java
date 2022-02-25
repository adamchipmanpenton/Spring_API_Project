package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GradesRepository extends CrudRepository<Grades, Integer> {
    Grades findGradesByGid(Integer gid);
    List<Grades> findAllByCourseId(Integer courseId);
    List<Grades> findAllByStudentId(Integer studentId);
    void deleteById(Integer id);
}
