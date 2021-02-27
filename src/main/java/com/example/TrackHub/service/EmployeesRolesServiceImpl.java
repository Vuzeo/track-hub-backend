package com.example.TrackHub.service;

import org.springframework.stereotype.Service;

import com.example.TrackHub.model.EmployeesRoles;
import com.example.TrackHub.repository.EmployeesRolesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesRolesServiceImpl implements EmployeesRolesService {
    private EmployeesRolesRepository employeesRolesRepository;

    public EmployeesRolesServiceImpl(EmployeesRolesRepository employeesRolesRepository) {
        this.employeesRolesRepository = employeesRolesRepository;
    }

    public List<EmployeesRoles> getEmployeesRoles() {
        List<EmployeesRoles> employeesRoles = new ArrayList<>();
        employeesRolesRepository.findAll().forEach(employeesRoles::add);
        return employeesRoles;
    }

    @Override
    public void createEmployeesRoles(EmployeesRoles employeesRoles) {
        employeesRolesRepository.save(employeesRoles);
    }

    @Override
    public void updateEmployeesRoles(Long id, EmployeesRoles employeesRoles) {
        employeesRolesRepository.deleteById(id);
        employeesRolesRepository.save(employeesRoles);
    }

    @Override
    public void deleteEmployeesRoles(Long id) {
        employeesRolesRepository.deleteById(id);
    }


}
