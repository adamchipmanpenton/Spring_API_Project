package com.example.java_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping("/add")
    public @ResponseBody
    String addEnrollment(@RequestParam int courseId, @RequestParam int studentId ) {
        Enrollment enrollment = new Enrollment();
        enrollment.setCourseId(courseId);
        enrollment.setStudentId(studentId);
        enrollmentRepository.save(enrollment);
        return "Added Enrollment to the education system.";
    }

    @GetMapping("/find/all")
    public Iterable<Enrollment> getEnrollment(){ return enrollmentRepository.findAll();}

    @GetMapping("/find/{eid}")
    public Enrollment findEnrollmentByID(@PathVariable Integer eid){return enrollmentRepository.findEnrollmentByeid(eid);}

    @GetMapping("/bycourse/{courseId}")
    public List<Enrollment> findCourseEnrollment(@PathVariable int courseId){
        return enrollmentRepository.findAllByCourseId(courseId);}

    @GetMapping("/bystudent/{studentId}")
    public List<Enrollment> findStudentEnrollment(@PathVariable int studentId){
        return enrollmentRepository.findAllByStudentId(studentId);}

    @DeleteMapping("/delete/{eid}")
    public String deleteEnrollment(@PathVariable Integer eid){
        enrollmentRepository.deleteById(eid);
        return "Enrollment " + eid + " was deleted.";}

    @PutMapping("/modify")
    public Enrollment modifyEnrollment(@RequestParam Integer eid, @RequestParam int courseId, @RequestParam int studentId ){
        Enrollment modifyEnrollment =  enrollmentRepository.findEnrollmentByeid(eid);
        modifyEnrollment.setCourseId(courseId);
        modifyEnrollment.setStudentId(studentId);
        enrollmentRepository.save(modifyEnrollment);
        return modifyEnrollment;}
}
