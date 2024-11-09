package com.example.Student_Management_System.DTOS;

import com.example.Student_Management_System.Entities.CourseEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;


@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentDtos {
    @Id
    @GeneratedValue(generator = "sixDigitIdGenerator")
    @GenericGenerator(name = "sixDigitIdGenerator", strategy = "com.example.Student_Management_System.ID.SixDigitIdGenerator")
    private Long studentId;
    private String studentName;
    private String studentDept;
   private List<CourseEntity> studentCourses;
}
