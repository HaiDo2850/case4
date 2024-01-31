package com.example.demo.controller;

import com.example.demo.model.NoteDetail;
import com.example.demo.model.TsDetail;
import com.example.demo.repository.NoteDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/note-details")
public class NoteDetailController {
    @Autowired
    NoteDetailRepository noteDetailRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(noteDetailRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(noteDetailRepository.findById(id),HttpStatus.OK);
    }

    @GetMapping("/search-by-tag")
    public ResponseEntity<List<NoteDetail>> findByTag(@RequestParam Long id) {
        List<NoteDetail> searchResult = noteDetailRepository.findAllByTag_id(id);
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }
}
