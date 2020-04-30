package com.greedycodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greedycodes.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
