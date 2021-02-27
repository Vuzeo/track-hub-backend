package com.example.TrackHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.Teams;

import java.io.Serializable;

@Repository
public interface TeamsRepository extends CrudRepository<Teams, Serializable> {
}
