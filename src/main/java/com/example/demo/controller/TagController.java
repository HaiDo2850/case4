package com.example.demo.controller;


import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tags")
public class TagController {
    @Autowired
    TagRepository tagRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(tagRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Tag tag) {
        return new ResponseEntity(tagRepository.save(tag), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody Tag tag , @PathVariable Long id) {
        tag.setId(id);
        return new ResponseEntity(tagRepository.save(tag), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        tagRepository.deleteById(id);
        return new ResponseEntity( "Delete Done",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(tagRepository.findById(id),HttpStatus.OK);
    }
}
