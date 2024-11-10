package com.example.Student_Management_System.Services;


import com.example.Student_Management_System.DTOS.CourseDtos;
import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Repositories.CourseRepository;
import com.example.Student_Management_System.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        CourseEntity newCourseEntity = CourseEntity.builder().courseId(courseDtos.getCourseId()).courseName(courseDtos.getCourseName()).build();
        return courseRepository.save(newCourseEntity);
    }

    @Override
    public void addStudentToCourse(Long studentId, String courseId) {
      CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not Found"));
      StudentEntity studentEntity= studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student Id not found"));
      courseEntity.getCourseTakenByStudents().add(studentEntity);
      studentEntity.getStudentsTakenCourses().add(courseEntity);
      studentRepository.save(studentEntity);
      courseRepository.save(courseEntity);
    }

    @Override
    public List<CourseEntity> addMultipleCourses(List<CourseDtos> courseDtos) {
       return courseDtos.stream().map(addCourses ->{
            CourseEntity newCourseEntity = CourseEntity.builder().courseId(addCourses.getCourseId()).courseName(addCourses.getCourseName()).build();
           return courseRepository.save(newCourseEntity);
       }).toList();
    }

    @Override
    public CourseDtos findCourseById(String courseId) {
        CourseEntity newCourseEntity=courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course Id not found"));
        return convertEntityToDto(newCourseEntity);
    }

    @Override
    public List<String> findCourseByStudentId(Long studentId) {
        StudentEntity newStudentEntity = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Id not found"));
        List<CourseEntity> newCourseEntity= newStudentEntity.getStudentsTakenCourses();
        return newCourseEntity.stream().map(eachCourse->{
            return eachCourse.getCourseId().toString()+" : "+eachCourse.getCourseName().toString();
        }).toList();

    }

    public CourseDtos convertEntityToDto(CourseEntity courseEntity){
        CourseDtos newCourseDto = new CourseDtos();
        newCourseDto.setCourseId(courseEntity.getCourseId());
        newCourseDto.setCourseName(courseEntity.getCourseName());

        List<String> students = courseEntity.getCourseTakenByStudents().stream().map(studentEntity -> {
            return studentEntity.getStudentId().toString()+" "+studentEntity.getStudentName();
        }).toList();

        newCourseDto.setCourseTakenByStudents(students);

        return newCourseDto;
    }
}
