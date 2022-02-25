package com.example.java_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public String addCourse(@RequestParam String courseName, @RequestParam String courseNumber, @RequestParam Integer capacity,
                            @RequestParam Integer year, @RequestParam String semester, @RequestParam String pid) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        course.setYear(year);
        course.setSemester(semester);
        course.setPaid(pid);
        courseRepository.save(course);
        return "Added course to the education system.";
    }

    @GetMapping("/find/all")
    public Iterable<Course> getCourses(){ return courseRepository.findAll();}
    @GetMapping("/find/{id}")
    public Course findCourseByID(@PathVariable Integer id){return courseRepository.findCourseByCourseId(id);}
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Integer id){
        courseRepository.deleteById(id);
        return "Course " + id + " was deleted.";}
    @PutMapping("/modify")
    public Course modifyStudent(@RequestParam Integer id, @RequestParam String courseName, @RequestParam String courseNumber, @RequestParam Integer capacity,
                                @RequestParam Integer year, @RequestParam String semester, @RequestParam String pid){
        Course modifyCourse =  courseRepository.findCourseByCourseId(id);
        modifyCourse.setCourseName(courseName);
        modifyCourse.setCourseNumber(courseNumber);
        modifyCourse.setCapacity(capacity);
        modifyCourse.setYear(year);
        modifyCourse.setSemester(semester);
        modifyCourse.setPaid(pid);
        courseRepository.save(modifyCourse);
        return modifyCourse;}
}
