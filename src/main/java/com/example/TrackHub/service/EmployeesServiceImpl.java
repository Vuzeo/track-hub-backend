package com.example.TrackHub.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.TrackHub.model.Employees;
import com.example.TrackHub.repository.EmployeesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesRepository employeesRepository;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public List<Employees> getEmployees() {
        List<Employees> employees = new ArrayList<Employees>();
        employeesRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public void createEmployees(Employees employees) {
        employeesRepository.save(employees);
    }

    @Override
    public void updateEmployees(Long id, Employees employees) {
        if (!employeesRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Save under the path id so the row is updated in place and keeps its foreign keys
        employees.setId(id);
        employeesRepository.save(employees);
    }

    @Override
    public void deleteEmployees(Long id) {
        employeesRepository.deleteById(id);
    }

}