package com.example.java_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/program")
public class ProgramsController {

    @Autowired
    private ProgramRepository programRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping("/add")
    public @ResponseBody String addProgram(@RequestParam String programName, @RequestParam String campus){
        Programs pro = new Programs();
        pro.setProgramName(programName);
        pro.setCampus(campus);
        programRepository.save(pro);
        return programName + " was added to the education system.";
    }
    @GetMapping("/find/all")
    public Iterable<Programs> getPrograms(){ return programRepository.findAll();}
    @GetMapping("/find/{pid}")
    public Programs findProgramByID(@PathVariable Integer pid){return programRepository.findProgramsByPid(pid);}
    @DeleteMapping("/delete/{pid}")
    public String deleteProgram(@PathVariable Integer pid){
        gradesRepository.deleteGrades( courseRepository.findCourses(pid));
        enrollmentRepository.deleteEnrollments(courseRepository.findCourses(pid));
        courseRepository.deleteCourse(pid);
        programRepository.deleteById(pid);
        return "Program " + pid + " was deleted.";}
    @PutMapping("/modify")
    public Programs modifyStudent(@RequestParam Integer pid, @RequestParam String programName, @RequestParam String campus){
        Programs modifyProgram =  programRepository.findProgramsByPid(pid);
        modifyProgram.setProgramName(programName);
        modifyProgram.setCampus(campus);
        programRepository.save(modifyProgram);
        return modifyProgram;
    }
}
