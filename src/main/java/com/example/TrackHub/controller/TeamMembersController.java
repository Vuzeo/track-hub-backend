package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.TeamMembers;
import com.example.TrackHub.repository.TeamMembersRepository;
import com.example.TrackHub.service.TeamMembersService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/teamMembers")
public class TeamMembersController {

    private TeamMembersService teamMembersService;
    private TeamMembersRepository teamMembersRepository;

    public TeamMembersController(TeamMembersService teamMembersService) {
        this.teamMembersService = teamMembersService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getTeamMembers() {
        return new ResponseEntity<>(teamMembersService.getTeamMembers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateTeamMembers(@PathVariable("id") Long id, @RequestBody TeamMembers teamMembers) {
        teamMembersService.updateTeamMembers(id, teamMembers);
        return new ResponseEntity<>("Team member is updated successfully", HttpStatus.OK);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTeamMembers(@PathVariable("id") Long id) {
        teamMembersService.deleteTeamMembers(id);
        return new ResponseEntity<>("Team member is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createTeamMembers(@RequestBody TeamMembers tpcTeamMembers) {
        teamMembersService.createTeamMembers(tpcTeamMembers);
        return new ResponseEntity<>(tpcTeamMembers, HttpStatus.OK);
    }
}
