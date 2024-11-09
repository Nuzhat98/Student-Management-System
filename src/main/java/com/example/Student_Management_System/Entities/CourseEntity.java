package com.example.Student_Management_System.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="Courses")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseEntity {
    @Id
    private String courseId;
    private String courseName;
    private List<StudentEntity> courseTakenByStudents;

    public CourseEntity(String courseId, String courseName) {
    }
}
