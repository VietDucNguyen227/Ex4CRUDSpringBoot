package com.example.ex4crud.controller;

import com.example.ex4crud.model.Student;
import com.example.ex4crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/Student", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> listAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        if (studentList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(studentList, HttpStatus.OK);
    }

    @RequestMapping(value = "Student", method = RequestMethod.POST)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @RequestMapping(value = "Student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,
                                                 @RequestBody Student student){
        Student oldStudent = studentService.getOne(id);
        if (oldStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldStudent.setName(student.getName());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setPhone(student.getPhone());
            studentService.saveStudent(oldStudent);
            return ResponseEntity.ok(oldStudent);
        }
    }

    @RequestMapping(value = "/Student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id){
        Optional<Student> deleteStudent = studentService.findStudentByID(id);
        if (deleteStudent == null){
            return ResponseEntity.notFound().build();
        }else{
            studentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    }

    @RequestMapping(value = "/Student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        Student student = studentService.getOne(id);
        return new ResponseEntity(student,HttpStatus.OK);
    }

    //http://localhost:8080/student/findStudentCode?studentCode=Ms1
    @GetMapping("/student/findStudentCode")
    public ResponseEntity<List<Student>> getByStudentId(@RequestParam String studentCode) {
        return new ResponseEntity<>(studentService.getStudentCode(studentCode), HttpStatus.OK);
    }

    //http://localhost:8080/student/findEmail?email=nvd@gmail.com
    @GetMapping("/student/findEmail")
    public ResponseEntity<List<Student>> getByEmail(@RequestParam String email) {
        return new ResponseEntity<>(studentService.getStudentEmail(email), HttpStatus.OK);
    }

    //http://localhost:8080/student/findPhone?phone=123456789
    @GetMapping("/student/findPhone")
    public ResponseEntity<List<Student>> getByPhone(@RequestParam String phone) {
        return new ResponseEntity<>(studentService.getStudentPhone(phone), HttpStatus.OK);
    }

}

