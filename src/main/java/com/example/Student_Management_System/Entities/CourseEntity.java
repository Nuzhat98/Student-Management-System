package com.example.Student_Management_System.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(
      name = "course-student",
            joinColumns = @JoinColumn(name="courseId"),
            inverseJoinColumns = @JoinColumn(name = "studentId")
    )
    private List<StudentEntity> courseTakenByStudents = new ArrayList<>();

    public CourseEntity(String courseId, String courseName) {
    }
}
