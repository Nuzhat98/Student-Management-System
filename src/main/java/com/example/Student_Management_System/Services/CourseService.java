package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.Entities.CourseEntity;

import java.util.List;


public interface CourseService {
    CourseEntity addCourse(CourseDtos courseDtos);

    void addStudentToCourse(Long studentId, String courseId);

    List<CourseEntity> addMultipleCourses(List<CourseDtos> courseDtos);

    CourseDtos findCourseById(String courseId);

    List<String> findCourseByStudentId(Long studentId);
}
