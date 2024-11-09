package com.example.Student_Management_System.Controllers;

import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Services.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course-section")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/add-course")
    public CourseEntity addCourse(@RequestBody CourseDtos courseDtos){
        return courseService.addCourse(courseDtos);
    }

    @PatchMapping("/add-students-to-course")
    public CourseEntity addStudent(@RequestBody StudentDtos studentDtos, @PathVariable("courseId") String courseId){
        return courseService.addStudent(studentDtos, courseId);
    }
}
