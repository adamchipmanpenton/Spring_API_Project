package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>{

    Course findCourseByCourseId(Integer courseId);
    void deleteById(Integer id);
}
