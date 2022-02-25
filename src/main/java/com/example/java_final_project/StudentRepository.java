package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>{

    Student findStudentById(Integer id);
    Student findStudentByFirstName(String firstName);
    Student findStudentByLastName(String lastName);
    Student findStudentByEmail(String email);
    Student findStudentByAddress(String address);
    Student findStudentByCity(String city);
    Student findStudentByPostal(String postal);
    Student findStudentByPhone(String phone);
    void deleteById(Integer id);
}
