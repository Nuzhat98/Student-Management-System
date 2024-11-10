package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.CourseEntity;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
