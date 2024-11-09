package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.StudentEntity;

public interface StudentService {
     StudentEntity addStudent(StudentDtos studentDtos);

}
