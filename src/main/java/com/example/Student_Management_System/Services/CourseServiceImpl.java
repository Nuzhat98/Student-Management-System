package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Repositories.CourseRepository;
import com.example.Student_Management_System.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public CourseEntity addCourse(CourseDtos courseDtos) {
        CourseEntity newCourseEntity = new CourseEntity(courseDtos.getCourseId(),courseDtos.getCourseName());
        return courseRepository.save(newCourseEntity);
    }

    @Override
    public CourseEntity addStudent(StudentDtos studentDtos, String courseId) {
        Optional<CourseEntity> courseEntityOp= courseRepository.findById(courseId);
        if(courseEntityOp.isPresent()){
            CourseEntity courseEntity = courseEntityOp.get();
            courseEntity.setCourseTakenByStudents((List<StudentEntity>) studentDtos);
            studentRepository.findById(studentDtos.getStudentId()).map(existingStudent ->{
                existingStudent.setStudentsTakenCourses((List<CourseEntity>) courseEntity);
                return null;
            });
            return courseRepository.save(courseEntity);
        }else{
            throw new RuntimeException("Course Id not found");
        }
    }
}
