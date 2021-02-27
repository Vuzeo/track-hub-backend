package com.example.TrackHub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.TrackHub.model.TeamMembers;

import java.io.Serializable;

@Repository
public interface TeamMembersRepository extends CrudRepository<TeamMembers, Serializable> {
}