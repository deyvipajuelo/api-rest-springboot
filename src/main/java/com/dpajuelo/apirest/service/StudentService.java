package com.dpajuelo.apirest.service;

import com.dpajuelo.apirest.exception.ApiException;
import com.dpajuelo.apirest.model.dto.RegisterStudentDto;
import com.dpajuelo.apirest.model.dto.UpdateStudentDto;
import com.dpajuelo.apirest.persistence.entity.Student;

public interface StudentService {
    Student saveStudent(RegisterStudentDto registerStudentDto) throws ApiException;

    Student updateStudent(UpdateStudentDto updateStudentDto, Long id) throws ApiException;

    Student findStudentById(Long id) throws ApiException;

    void deleteStudent(Long id) throws ApiException;
//    Integer saveAuthor(RegisterAuthorDto registerAuthorDto) throws ApiException;
//
//     updateStudent(Student student);
//
//    void deleteAuthor(Integer authorId) throws ApiException;
//
//    AuthorProjection findAuthorId(Integer authorId) throws ApiException;
//
//    List<AuthorProjection> findAll(AuthorSpecification authorSpecification);
}
