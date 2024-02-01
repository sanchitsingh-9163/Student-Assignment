package com.api.student.bootreststudent.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.student.bootreststudent.dao.StudentRepository;
import com.api.student.bootreststudent.entity.Student;

@Component
public class StudentService {
    @Autowired
    private StudentRepository bookRepository;

    public List<Student> getAllStudents(){
        
        return (List<Student>)this.bookRepository.findAll();
    }

    public Student getStudent(int id){
        return this.bookRepository.findById(id);
    }
    
    public Student addStudent(Student b){

        this.bookRepository.save(b);
        return b;

    }
}
