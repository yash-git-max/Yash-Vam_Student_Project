package org.example.controllers;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
//import org.example.DTO.response.PageResponse;
import org.example.DTO.response.PaginationResponseDTO;
import org.example.DTO.response.StudentsResponse;
import org.example.domain.Student;
import org.example.exception.nostudents;
import org.example.repository.StudentRepository;
import org.example.service.Impl.StudentServiceImpl;
import org.example.service.StudentService;
//import org.example.service.StudentService_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service=new StudentServiceImpl();
//    @Autowired
//    StudentsResponse stresp;


    @PostMapping
    public ResponseEntity<StudentsResponse> mapping(@Valid @RequestBody Student student){
        Student student1 =service.createStudent(student);

        StudentsResponse<Student> stresp=new StudentsResponse<>();
        stresp.setStatus(HttpStatus.CREATED.value());
        stresp.setTimestamp(LocalDateTime.now());
        stresp.setData(List.of(student1));
        stresp.setMessage("Vamshi this is your data");
//        if(student1==null){
//            throw new nostudents();
//        }
        return new ResponseEntity<>(stresp,HttpStatus.CREATED);
    }

    @GetMapping("/getstudents/{id}")
    public ResponseEntity<StudentsResponse> getstudent(@PathVariable Long id){
        Student student=service.getStudentById(id);
        StudentsResponse<Student> stresp=new StudentsResponse<>();
//        private int status;
//        private String message;
//        private List<T> data;
//        private LocalDateTime timestamp;
        stresp.setStatus(HttpStatus.OK.value());
        stresp.setMessage("This is your requested data");
        stresp.setData(List.of(student));
        stresp.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(stresp,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student>deletestud(@PathVariable Long id){
       Student deletedStudent= service.deleteStudent(id);
        return new ResponseEntity<>(deletedStudent,HttpStatus.OK);
    }
    @GetMapping("/getstudents")
    public ResponseEntity<StudentsResponse> getallstudents(){
        StudentsResponse<Student> stresp=new StudentsResponse<>();
        stresp.setStatus(HttpStatus.OK.value());
        stresp.setTimestamp(LocalDateTime.now());
        stresp.setData(service.getAllStudents());
        stresp.setMessage("Vamshi this is your data");
        return new ResponseEntity<>(stresp,HttpStatus.OK);
    }
//
//    @GetMapping("/studentdetails/pagination")
//    public ResponseEntity<PaginationResponseDTO> getstudents(
//            @RequestParam(defaultValue ="0")int page,
//            @RequestParam(defaultValue = "5") int size,
//        @RequestParam(defaultValue = "id") String sortBy
//    ) {
//
//PaginationResponseDTO<Student> pagresp=new PaginationResponseDTO<>();
//        service.pagination(page,size,sortBy);
//        return null;
//              //  ResponseEntity<>(pagresp, size, sortBy);
//    }

}
