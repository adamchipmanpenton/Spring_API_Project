package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    Course findCourseByCourseId(Integer courseId);
    void deleteById(Integer id);
    default List<Course> findCourses(Integer pid){
        Iterable<Course> courses = findAll();
        ArrayList<Course> coursesToDelete = new ArrayList<>();
        for (Course c : courses) {
            if (Objects.equals(c.getPid(), pid)) {
                coursesToDelete.add(c);
            }
        }
        return coursesToDelete;
    }

    default void deleteCourse(Integer courseId) {
        Iterable<Course> courses = findAll();
        for (Course c : courses) {
            if (Objects.equals(c.getPid(), courseId)) {
                delete(c);
            }
        }
    }
}
