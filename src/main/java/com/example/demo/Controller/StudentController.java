package com.example.demo.Controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(studentRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }
}
