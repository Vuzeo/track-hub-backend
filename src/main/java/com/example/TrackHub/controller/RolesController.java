package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.Roles;
import com.example.TrackHub.repository.RolesRepository;
import com.example.TrackHub.service.RolesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private RolesRepository roles;
    private RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getRoles() {
        return new ResponseEntity<>(rolesService.getRoles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateRole(@PathVariable("id") Long id, @RequestBody Roles roles) {
        rolesService.updateRole(id, roles);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRole(@PathVariable("id") Long id) {
        rolesService.deleteRole(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createRole(@RequestBody Roles projectActivities) {
        rolesService.createRole((com.example.TrackHub.model.Roles) roles);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
}
