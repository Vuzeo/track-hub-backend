package com.example.TrackHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {

}
