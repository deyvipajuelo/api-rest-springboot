package com.dpajuelo.apirest.persistence.repository;

import com.dpajuelo.apirest.persistence.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, CrudRepository<Student, Long> {

}
