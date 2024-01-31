package com.example.demo.controller;

import com.example.demo.model.TsDetail;
import com.example.demo.repository.TsDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/task-assignment-details")
public class TaskAssignmentDetailController {
    @Autowired
    TsDetailRepository tsDetailRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(tsDetailRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(tsDetailRepository.findById(id),HttpStatus.OK);
    }

    @GetMapping("/find-task-assignment-of-Team")
    public ResponseEntity<List<TsDetail>> findTaskByTeam(@RequestParam Long id) {
        List<TsDetail> searchResult = tsDetailRepository.findByTeamId(id);
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }

    @GetMapping("/find-by-user-id")
    public ResponseEntity<List<TsDetail>> findNoteByUser(@RequestParam Long id) {
        List<TsDetail> searchResult = tsDetailRepository.findAllByUser_id(id);
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }
}
