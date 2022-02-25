package com.example.java_final_project;

import org.springframework.data.repository.CrudRepository;

public interface ProgramRepository extends CrudRepository<Programs, Integer> {
    Programs findProgramsByPid(Integer pid);
    void deleteById(Integer id);
}
