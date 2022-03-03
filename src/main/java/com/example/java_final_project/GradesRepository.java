package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Objects;

public interface GradesRepository extends CrudRepository<Grades, Integer> {
    Grades findGradesByGid(Integer gid);
    List<Grades> findAllByCourseId(Integer courseId);
    List<Grades> findAllByStudentId(Integer studentId);
    void deleteById(Integer id);
    default void deleteStudent(Integer studentId){
        Iterable <Grades> grades = findAll();
        for (Grades grade : grades) {
            if (Objects.equals(grade.getStudentId(), studentId)) {
                delete(grade);
            }
        }
    }
    default void deleteCourse(Integer courseId) {
        Iterable <Grades> grades = findAll();
        for (Grades grade : grades) {
            if (Objects.equals(grade.getCourseId(), courseId)) {
                delete(grade);
            }
        }
    }

    default void deleteGrades(List<Course> courses){
        Iterable <Grades> grades = findAll();
        for (Grades grade : grades) {
            for (Course c : courses) {
                if (Objects.equals(grade.getCourseId(), c.getCourseId())) {
                    delete(grade);
                }
            }
        }
    }
}
