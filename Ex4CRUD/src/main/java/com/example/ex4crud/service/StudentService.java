package com.example.ex4crud.service;

import com.example.ex4crud.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();

    void saveStudent(Student student);

    void deleteStudent(int id);

    Optional<Student> findStudentByID(int id);

    public Student getOne(int id);

    List<Student> getStudentCode(String studentCode);

    List<Student> getStudentEmail(String email);

    List<Student> getStudentPhone(String phone);

}
