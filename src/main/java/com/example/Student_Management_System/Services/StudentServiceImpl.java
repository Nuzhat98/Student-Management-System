package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Repositories.CourseRepository;
import com.example.Student_Management_System.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDtos addStudent(StudentDtos studentDtos) {
        StudentEntity newStudentEntity = StudentEntity.builder().studentName(studentDtos.getStudentName()).studentDept(studentDtos.getStudentDept()).build();
         studentRepository.save(newStudentEntity);
        return convertEntityToDto(newStudentEntity);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentDtos findStudentById(Long studentId) {

        return convertEntityToDto(studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Id Not Found")));
    }

    @Override
    public List<StudentDtos> findStudentByCourse(String courseId) {
        CourseEntity newCourseEntity = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("Invalid Course ID"));
        List<StudentEntity> newStudentEntities= newCourseEntity.getCourseTakenByStudents();
        return newStudentEntities.stream().map(this::convertEntityToDto).toList();
    }


    public StudentDtos convertEntityToDto(StudentEntity studentEntity){
        StudentDtos newStudentDto= new StudentDtos();
        newStudentDto.setStudentId(studentEntity.getStudentId());
        newStudentDto.setStudentName(studentEntity.getStudentName());
        newStudentDto.setStudentName(studentEntity.getStudentName());
        newStudentDto.setStudentDept(studentEntity.getStudentDept());

        List<String> courses = studentEntity.getStudentsTakenCourses().stream().map(CourseEntity::getCourseName).toList();

        newStudentDto.setStudentCourses(courses);

        return newStudentDto;
    }
}
