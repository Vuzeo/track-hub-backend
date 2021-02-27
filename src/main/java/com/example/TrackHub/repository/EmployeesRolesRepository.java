package com.example.TrackHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.EmployeesRoles;

@Repository
public interface EmployeesRolesRepository extends CrudRepository<EmployeesRoles, Long> {

}

