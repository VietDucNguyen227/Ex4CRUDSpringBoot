package com.example.ex4crud.repository;

import com.example.ex4crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentCode(String studentCode);
    List<Student> findByEmail(String email);
    List<Student> findByPhone(String phone);

}
