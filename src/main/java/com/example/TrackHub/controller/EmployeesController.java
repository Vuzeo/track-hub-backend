package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.Employees;
import com.example.TrackHub.repository.EmployeesRepository;
import com.example.TrackHub.service.EmployeesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    private EmployeesService employeesService;
    private EmployeesRepository employeesRepository;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getEmployees() {
        return new ResponseEntity<>(employeesService.getEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateEmployees(@PathVariable("id") Long id, @RequestBody Employees employees) {
        employeesService.updateEmployees(id, employees);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployees(@PathVariable("id") Long id) {
        employeesService.deleteEmployees(id);
        return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createEmployees(@RequestBody Employees employees) {
        employeesService.createEmployees(employees);
        return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
    }

}

