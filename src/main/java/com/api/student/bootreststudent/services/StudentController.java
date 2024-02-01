package com.api.student.bootreststudent.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.student.bootreststudent.entity.Student;

@RestController
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> list = this.studentService.getAllStudents();

        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(studentService.getAllStudents()));
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){

        Student book =this.studentService.getStudent(id); 
        if(book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(studentService.getStudent(id)));
        
    }

    @PostMapping("/students")
    public ResponseEntity<Optional<Student>> addStudent(@RequestBody Student book){
        Student b=null;
    
        try{
            b=  this.studentService.addStudent(book);
            return ResponseEntity.ok(Optional.of(b));        
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

}
