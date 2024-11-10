package com.example.Student_Management_System.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "Students")
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "sixDigitIdGenerator")
    @GenericGenerator(name = "sixDigitIdGenerator", strategy = "com.example.Student_Management_System.ID.SixDigitIdGenerator")
    private Long studentId;
    private String studentName;
    private String studentDept;
    @ManyToMany(mappedBy = "courseTakenByStudents")
    private List<CourseEntity> studentsTakenCourses=new ArrayList<>();

    public StudentEntity(Long studentId, String studentName, String studentDept) {
    }

    public StudentEntity(String studentName, String studentDept) {
    }
}
