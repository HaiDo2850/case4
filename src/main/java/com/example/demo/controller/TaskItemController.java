package com.example.demo.controller;

import com.example.demo.repository.TaskItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tasks")
public class TaskItemController {
    @Autowired
    TaskItemRepository taskItemRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(taskItemRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(taskItemRepository.findById(id), HttpStatus.OK);
    }

}
