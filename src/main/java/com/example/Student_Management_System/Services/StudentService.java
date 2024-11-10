package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.StudentEntity;

public interface StudentService {
     StudentDtos addStudent(StudentDtos studentDtos);

    void deleteStudentById(Long studentId);

    StudentDtos findStudentById(Long studentId);
}
