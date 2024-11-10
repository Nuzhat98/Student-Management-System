package com.example.Student_Management_System.Repositories;

import com.example.Student_Management_System.DTOS.StudentDtos;
import com.example.Student_Management_System.Entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

}
