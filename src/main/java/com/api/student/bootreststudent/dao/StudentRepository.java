package com.api.student.bootreststudent.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.student.bootreststudent.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    
    public Student findById(int id);
}
