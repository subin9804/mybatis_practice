package com.example.school.repository;

import com.example.school.domain.Student;
import com.example.school.domain.StudentInquiryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {
    List<Student> findAll();
    Student findById(int id);
    void updateStudent(Student student);
    int addStudent(Student student);
    List<Student> findByInquiryDto(StudentInquiryDto studentInquiryDto);
}