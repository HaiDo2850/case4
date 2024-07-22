package com.example.demo.Controller;

import com.example.demo.model.Class;
import com.example.demo.service.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    ClassRepository classRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(classRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(classRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity add(@RequestBody Class aClass) {
        return new ResponseEntity<>(classRepository.save(aClass), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Class aClass) {
        aClass.setId(id);
        return new ResponseEntity<>(classRepository.save(aClass), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id, @RequestBody Class aclass) {
        aclass.setId(id);
        return new ResponseEntity<>(classRepository.save(aclass), HttpStatus.OK);
    }
}
