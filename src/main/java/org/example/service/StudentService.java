package org.example.service;

import org.example.DTO.response.StudentsResponse;
import org.example.domain.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student deleteStudent(Long id);

    Page<Student> pagination(int page, int size,String sortBy );

}
