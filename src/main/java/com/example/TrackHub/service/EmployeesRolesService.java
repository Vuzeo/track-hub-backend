package com.example.TrackHub.service;

import com.example.TrackHub.model.EmployeesRoles;

public interface EmployeesRolesService {

    public abstract void createEmployeesRoles(EmployeesRoles employeesRoles);

    public abstract void updateEmployeesRoles(Long id, EmployeesRoles employeesRoles);

    public abstract void deleteEmployeesRoles(Long id);

    public abstract Object getEmployeesRoles();

}
