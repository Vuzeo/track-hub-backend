package com.example.TrackHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.Employees;

@Repository
public interface EmployeesRepository extends CrudRepository<Employees, Long> {

}
