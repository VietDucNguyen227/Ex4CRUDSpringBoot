package com.example.ex4crud.service;

import com.example.ex4crud.model.Student;
import com.example.ex4crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findStudentByID(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student getOne(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getStudentCode(String studentCode) {
        return null;
    }

    @Override
    public List<Student> getStudentEmail(String email) {
        return null;
    }

    @Override
    public List<Student> getStudentPhone(String phone) {
        return null;
    }
}
