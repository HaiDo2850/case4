package com.example.demo.controller;


import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(teamRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Team team) {
        return new ResponseEntity(teamRepository.save(team), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody Team team , @PathVariable Long id) {
        team.setId(id);
        return new ResponseEntity(teamRepository.save(team), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return new ResponseEntity( "Delete Done",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return new ResponseEntity(teamRepository.findById(id),HttpStatus.OK);
    }

    @GetMapping("/findByUser")
    public ResponseEntity<List<Team>> findByUserId(@RequestParam Long id){
        List<Team> searchResult= teamRepository.findTeamByUser(id);
        return new ResponseEntity(searchResult,HttpStatus.OK);
    }
}
