package com.example.demo.controller;


import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(noteRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Note note) {
        return new ResponseEntity(noteRepository.save(note), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody Note note , @PathVariable Long id) {
        note.setId(id);
        return new ResponseEntity(noteRepository.save(note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return new ResponseEntity( "Delete Done",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(noteRepository.findById(id),HttpStatus.OK);
    }
}
