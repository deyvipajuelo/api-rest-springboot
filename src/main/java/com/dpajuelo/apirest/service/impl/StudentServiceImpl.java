package com.dpajuelo.apirest.service.impl;

import com.dpajuelo.apirest.exception.ApiException;
import com.dpajuelo.apirest.model.dto.RegisterStudentDto;
import com.dpajuelo.apirest.model.dto.UpdateStudentDto;
import com.dpajuelo.apirest.persistence.entity.Student;
import com.dpajuelo.apirest.persistence.repository.StudentRepository;
import com.dpajuelo.apirest.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Student saveStudent(RegisterStudentDto registerStudentDto) throws ApiException{
        try {
            Student student = modelMapper.map(registerStudentDto, Student.class);

            return studentRepository.save(student);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error while saving student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public Student updateStudent(UpdateStudentDto updateStudentDto, Long studentId) throws ApiException{
        try {
            Student student = studentRepository.findById(studentId).orElse(null);

            if (student == null) throw new ApiException("Student not found", HttpStatus.NOT_FOUND);

            student = modelMapper.map(updateStudentDto, Student.class);

            student.setStudentId(studentId);
             return studentRepository.save(student);

        } catch (ApiException e) {
            log.error(e.getMessage());
            throw new ApiException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error while saving student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Student findStudentById(Long studentId) throws ApiException {
        try {
            Student student = studentRepository.findById(studentId).orElse(null);
            if (student == null) throw new ApiException("Student not found", HttpStatus.NOT_FOUND);
            return student;
        } catch (Exception e) {
            throw new ApiException("Error finding the student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deleteStudent(Long studentId) throws ApiException {
        try {
            Student student = studentRepository.findById(studentId).orElse(null);
            if (student == null) throw new ApiException("Student not found", HttpStatus.NOT_FOUND);
            studentRepository.deleteById(studentId);
        } catch (ApiException e) {
            log.error(e.getMessage());
            throw new ApiException(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ApiException("Error deleting the student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
