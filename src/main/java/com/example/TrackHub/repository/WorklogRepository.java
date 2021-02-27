package com.example.TrackHub.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.Worklog;

import java.io.Serializable;

@Repository
public interface WorklogRepository extends CrudRepository<Worklog, Serializable> {

}
