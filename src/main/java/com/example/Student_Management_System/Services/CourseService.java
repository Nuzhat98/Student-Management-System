package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseService {
    CourseEntity addCourse(CourseDtos courseDtos);

    CourseEntity addStudentToCourse(Long studentId, String courseId);

    List<CourseEntity> addMultipleCourses(List<CourseDtos> courseDtos);
}
