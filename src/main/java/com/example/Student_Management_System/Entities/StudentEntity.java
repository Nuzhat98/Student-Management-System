package com.example.Student_Management_System.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
    private List<CourseEntity> studentsTakenCourses;
}
