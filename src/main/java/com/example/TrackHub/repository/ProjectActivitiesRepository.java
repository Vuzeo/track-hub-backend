package com.example.TrackHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.ProjectActivities;

@Repository
public interface ProjectActivitiesRepository extends CrudRepository<ProjectActivities, Long> {

}
