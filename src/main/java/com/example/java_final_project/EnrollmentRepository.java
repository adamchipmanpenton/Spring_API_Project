package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

public interface  EnrollmentRepository extends CrudRepository<Enrollment, Integer>{
    Enrollment findEnrollmentByeid(Integer eid);
    Enrollment findEnrollmentBycourseId(Integer courseId);
    List<Enrollment> findAllByCourseId(Integer courseId);
    List<Enrollment> findAllByStudentId(Integer studentId);
    void deleteById(Integer eid);

    default void deleteStudent(Integer studentId){
        Iterable <Enrollment> enrollments = findAll();
        for (Enrollment enrollment : enrollments) {
            if (Objects.equals(enrollment.getStudentId(), studentId)) {
                delete(enrollment);
            }
        }
    }

    default void deleteCourse(Integer courseId) {
        Iterable<Enrollment> enrollments = findAll();
        for (Enrollment enrollment : enrollments) {
            if (Objects.equals(enrollment.getCourseId(), courseId)) {
                delete(enrollment);
            }
        }
    }

     default void deleteEnrollments(List<Course> courses){
         Iterable <Enrollment> enrollments = findAll();
         for (Enrollment e : enrollments) {
             for (Course c : courses) {
                 if (Objects.equals(e.getCourseId(), c.getCourseId())) {
                     delete(e);
                 }
             }
         }

     };
}
