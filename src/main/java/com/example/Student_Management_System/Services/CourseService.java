package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;

public interface CourseService {
    CourseEntity addCourse(CourseDtos courseDtos);

    CourseEntity addStudent(StudentDtos studentDtos, String courseId);
}
