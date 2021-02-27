package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.Teams;
import com.example.TrackHub.repository.TeamsRepository;
import com.example.TrackHub.service.TeamsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/teams")
public class TeamsController {

    private TeamsService teamsService;
    private TeamsRepository teamsRepository;

    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getTeams() {
        return new ResponseEntity<>(teamsService.getTeams(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateTeam(@PathVariable("id") Long id, @RequestBody Teams teams) {
        teamsService.updateTeam(id, teams);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTeam(@PathVariable("id") Long id) {
        teamsService.deleteTeam(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createTeam(@RequestBody Teams newTeam) {
        teamsService.createTeam(newTeam);
        return new ResponseEntity<>(newTeam, HttpStatus.OK);
    }
}
