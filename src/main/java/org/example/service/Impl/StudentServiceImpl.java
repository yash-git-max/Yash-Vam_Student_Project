package org.example.service.Impl;

import org.example.exception.Exceptions;
import org.example.exception.StudentNotFoundException;
import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student>getAllStudents(){
//
//      if(studentRepository.findAll()!=null){
//          throw new cust_studentnull("null issue");
//      }
        return studentRepository.findAll();
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(HttpStatus.NOT_FOUND));
    }

    public Student deleteStudent(Long id){
        Student student =studentRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new Exceptions("student not found"));
        studentRepository.delete(student);
        return student;
    }

    public Page<Student> pagination(int page, int size, String sortBy ){
        Pageable pageable = PageRequest.of(page,size);
         Page<Student> p=studentRepository.findAll(pageable);
//        return new PaginationResponseDTO<>(
//                p.getContent(),
//                p.getNumber(),
//                p.getSize(),
//                p.getTotalElements(),
//                p.getTotalPages(),
//                p.isLast()
//        );
        return null;


    }


}
