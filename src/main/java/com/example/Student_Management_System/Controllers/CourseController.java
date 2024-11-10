package com.example.Student_Management_System.Controllers;

import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-section")
public class CourseController {

    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add-multiple-course")
    public List<CourseEntity> addMultipleCourses(@RequestBody List<CourseDtos> courseDtos){
        return courseService.addMultipleCourses(courseDtos);
    }

    @PostMapping("/add-course")
    public CourseEntity addCourse(@RequestBody CourseDtos courseDtos){
        return courseService.addCourse(courseDtos);
    }

    @PatchMapping("/{courseId}/add-students-to-course/{studentId}")
    public String addStudentToCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") String courseId){
         courseService.addStudentToCourse(studentId, courseId);
         return studentId+" added to "+courseId+" successfully!";
    }
}
