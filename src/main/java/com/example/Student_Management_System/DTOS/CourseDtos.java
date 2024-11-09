package com.example.Student_Management_System.DTOS;

import com.example.Student_Management_System.Entities.StudentEntity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseDtos {
    @Id
    private String courseId;
    private String courseName;
    private List<StudentEntity> courseTakenByStudents;
}
