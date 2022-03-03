package com.example.java_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="/grades")
public class GradesController {

    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping("/add")
    public @ResponseBody String addGrades(@RequestParam int studentId, @RequestParam int courseId, @RequestParam int grade ) {
        Grades grades = new Grades();
        grades.setStudentId(studentId);
        grades.setCourseId(courseId);
        grades.setGrade(grade);
        gradesRepository.save(grades);
        return "Added grade to the education system.";
    }

    @GetMapping("/find/all")
    public Iterable<Grades> getGrades(){ return gradesRepository.findAll();}
    @GetMapping("/find/{gid}")
    public Grades findGradesByID(@PathVariable Integer gid){return gradesRepository.findGradesByGid(gid);}

    @GetMapping("/bycourse/{courseId}")
    public List<Grades> findCourseGrades(@PathVariable int courseId){
        return gradesRepository.findAllByCourseId(courseId);}

    @GetMapping("/bystudent/{studentId}")
    public List<Grades> findStudentGrades(@PathVariable int studentId){
        return gradesRepository.findAllByStudentId(studentId);}

    @DeleteMapping("/delete/{gid}")
    public String deleteGrades(@PathVariable Integer gid){
        gradesRepository.deleteById(gid);
        return "Student " + gid + " was deleted.";}

    @PutMapping("/modify")
    public Grades modifyStudent(@RequestParam Integer gid, @RequestParam int studentId, @RequestParam int courseId, @RequestParam int grade ){
        Grades modifyGrades = gradesRepository.findGradesByGid(gid);
        modifyGrades.setStudentId(studentId);
        modifyGrades.setCourseId(courseId);
        modifyGrades.setGrade(grade);
        gradesRepository.save(modifyGrades);
        return modifyGrades;}
}