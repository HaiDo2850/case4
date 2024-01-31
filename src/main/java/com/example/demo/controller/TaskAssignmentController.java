package com.example.demo.controller;


import com.example.demo.model.TaskAssignment;
import com.example.demo.repository.TaskAssiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/task-assignments")
public class TaskAssignmentController {
    @Autowired
    TaskAssiRepository taskAssiRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(taskAssiRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TaskAssignment taskAssignment) {
        return new ResponseEntity(taskAssiRepository.save(taskAssignment), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody TaskAssignment taskAssignment , @PathVariable Long id) {
        taskAssignment.setId(id);
        return new ResponseEntity(taskAssiRepository.save(taskAssignment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        taskAssiRepository.deleteById(id);
        return new ResponseEntity( "Delete Done",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(taskAssiRepository.findById(id),HttpStatus.OK);
    }

}
