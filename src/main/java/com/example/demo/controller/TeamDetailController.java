package com.example.demo.controller;

import com.example.demo.model.TeamDetail;
import com.example.demo.repository.TeamDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/team-details")
public class TeamDetailController {
    @Autowired
    TeamDetailRepository teamDetailRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity(teamDetailRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(teamDetailRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findByRole")
    public ResponseEntity<List<TeamDetail>> findByUserId(@RequestParam String role) {
        List<TeamDetail> searchResult = teamDetailRepository.findUserByRole(role);
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }

    @GetMapping("/findTeamCreate")
    public ResponseEntity<List<TeamDetail>> findTeamCreate(@RequestParam Long id, @RequestParam String role) {
        List<TeamDetail> searchResult = teamDetailRepository.findTeamByUser(id, role);
        return new ResponseEntity(searchResult, HttpStatus.OK);
    }
}
