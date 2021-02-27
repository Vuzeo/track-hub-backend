package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.EmployeesRoles;
import com.example.TrackHub.repository.EmployeesRolesRepository;
import com.example.TrackHub.service.EmployeesRolesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employeesRoles")
public class EmployeesRolesController {

    private EmployeesRolesService employeesRolesService;
    private EmployeesRolesRepository employeesRolesRepository;

    public EmployeesRolesController(EmployeesRolesService employeesRolesService) {
        this.employeesRolesService = employeesRolesService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getEmployeesRoles() {
        return new ResponseEntity<>(employeesRolesService.getEmployeesRoles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateEmployeesRole(@PathVariable("id") Long id, @RequestBody EmployeesRoles employeesRoles) {
        employeesRolesService.updateEmployeesRoles(id, employeesRoles);
        return new ResponseEntity<>("Employee role is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployeesRole(@PathVariable("id") Long id) {
        employeesRolesService.deleteEmployeesRoles(id);
        return new ResponseEntity<>("Employee role is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createEmployeesRole(@RequestBody EmployeesRoles employeesRoles) {
        employeesRolesService.createEmployeesRoles(employeesRoles);
        return new ResponseEntity<>(employeesRoles, HttpStatus.OK);
    }

}