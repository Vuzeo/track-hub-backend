package com.example.TrackHub.service;

import com.example.TrackHub.model.Employees;

public interface EmployeesService {

    public abstract Object getEmployees();

    public abstract void createEmployees(Employees employees);

    public abstract void updateEmployees(Long id, Employees employees);

    public abstract void deleteEmployees(Long id);
}
