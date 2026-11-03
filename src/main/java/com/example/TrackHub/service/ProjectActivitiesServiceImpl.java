package com.example.TrackHub.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.TrackHub.model.ProjectActivities;
import com.example.TrackHub.repository.ProjectActivitiesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectActivitiesServiceImpl implements ProjectActivitiesService {
    private final ProjectActivitiesRepository projectActivitiesRepository;

    public ProjectActivitiesServiceImpl(ProjectActivitiesRepository projectActivitiesRepository) {
        this.projectActivitiesRepository = projectActivitiesRepository;
    }

    @Override
    public void createProjectActivity(ProjectActivities projectActivities) {
        projectActivitiesRepository.save(projectActivities);
    }

    @Override
    public void updateProjectActivity(Long id, ProjectActivities projectActivities) {
        if (!projectActivitiesRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Save under the path id so the row is updated in place and keeps its foreign keys
        projectActivities.setId(id);
        projectActivitiesRepository.save(projectActivities);
    }

    @Override
    public void deleteProjectActivity(Long id) {
        projectActivitiesRepository.deleteById(id);
    }

    @Override
    public List<ProjectActivities> getProjectActivities() {
        List<ProjectActivities> projectActivities = new ArrayList<ProjectActivities>();
        projectActivitiesRepository.findAll().forEach(projectActivities::add);
        return projectActivities;
    }
}
