package com.example.Student_Management_System.Controllers;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-section")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/greet")
    public String greetStudent(){
        return "Welcome to Student Section";
    }

    @PostMapping("/add-student")
    public StudentEntity addStudent(@RequestBody StudentDtos studentDtos){
        return studentService.addStudent(studentDtos);
    }

    @DeleteMapping("/delete-student/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long studentId){
         studentService.deleteStudentById(studentId);
    }
}
