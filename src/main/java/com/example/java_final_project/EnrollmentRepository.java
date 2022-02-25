package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface  EnrollmentRepository extends CrudRepository<Enrollment, Integer>{
    Enrollment findEnrollmentByeid(Integer eid);
    Enrollment findEnrollmentBycourseId(Integer courseId);

    List<Enrollment> findAllByCourseId(Integer courseId);
    List<Enrollment> findAllByStudentId(Integer studentId);
    void deleteById(Integer eid);
}
