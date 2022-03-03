package com.example.java_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private GradesRepository gradesRepository;

    @PostMapping("/add")
    public @ResponseBody String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String address, @RequestParam String city, @RequestParam String postal, @RequestParam String phone  ) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setAddress(address);
        student.setCity(city);
        student.setPostal(postal);
        student.setPhone(phone);
        studentRepository.save(student);
        return firstName + " " + lastName + " to the education system.";
    }

    @GetMapping("/find/all")
    public Iterable<Student> getStudents(){ return studentRepository.findAll();}
    @GetMapping("/find/{studentId}")
    public Student findStudentByID(@PathVariable Integer studentId){return studentRepository.findStudentByStudentId(studentId);}
    @DeleteMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable Integer studentId){
        enrollmentRepository.deleteStudent(studentId);
        gradesRepository.deleteStudent(studentId);
        studentRepository.deleteById(studentId);
        return "Student " + studentId + " was deleted.";}
    @PutMapping("/modify")
    public Student modifyStudent(@RequestParam Integer studentId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String address, @RequestParam String city, @RequestParam String postal, @RequestParam String phone ){
        Student modifyStudent =  studentRepository.findStudentByStudentId(studentId);
        modifyStudent.setFirstName(firstName);
        modifyStudent.setLastName(lastName);
        modifyStudent.setEmail(email);
        modifyStudent.setAddress(address);
        modifyStudent.setCity(city);
        modifyStudent.setPostal(postal);
        modifyStudent.setPhone(phone);
        studentRepository.save(modifyStudent);
        return modifyStudent;}
}
