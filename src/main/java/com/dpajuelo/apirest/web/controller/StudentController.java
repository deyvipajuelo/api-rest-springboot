package com.dpajuelo.apirest.web.controller;

import com.dpajuelo.apirest.exception.ApiException;
import com.dpajuelo.apirest.model.dto.RegisterStudentDto;
import com.dpajuelo.apirest.model.dto.UpdateStudentDto;
import com.dpajuelo.apirest.persistence.entity.Student;
import com.dpajuelo.apirest.service.StudentService;
import com.dpajuelo.apirest.web.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    ResponseEntity<Student> findStudentById(@PathVariable Long id) throws ApiException{
        Student student = studentService.findStudentById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<ResponseMessage<Student>> saveStudent(@RequestBody RegisterStudentDto registerStudentDto) throws ApiException {
        Student student = studentService.saveStudent(registerStudentDto);

        return new ResponseEntity<>(ResponseMessage.of(
                "Student saved successfully", student),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseMessage<Student>> updateStudent(@RequestBody UpdateStudentDto updateStudentDto, @PathVariable Long id) throws ApiException {
        Student student = studentService.updateStudent(updateStudentDto, id);

        return new ResponseEntity<>(ResponseMessage.of(
                "Student saved successfully", student),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteStudent(@PathVariable Long id) throws ApiException{
        studentService.deleteStudent(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
