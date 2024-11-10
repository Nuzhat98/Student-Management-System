package com.example.Student_Management_System.Services;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.StudentEntity;
import com.example.Student_Management_System.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity addStudent(StudentDtos studentDtos) {
        StudentEntity newStudentEntity = StudentEntity.builder().studentName(studentDtos.getStudentName()).studentDept(studentDtos.getStudentDept()).build();
        return studentRepository.save(newStudentEntity);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
