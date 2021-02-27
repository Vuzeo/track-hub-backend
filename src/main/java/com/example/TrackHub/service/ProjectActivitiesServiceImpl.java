package com.example.TrackHub.service;

import org.springframework.stereotype.Service;

import com.example.TrackHub.model.ProjectActivities;
import com.example.TrackHub.repository.ProjectActivitiesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectActivitiesServiceImpl implements ProjectActivitiesService {
    ProjectActivitiesRepository projectActivitiesRepository;

    public ProjectActivitiesServiceImpl(ProjectActivitiesRepository projectActivitiesRepository) {
        this.projectActivitiesRepository = projectActivitiesRepository;
    }

    @Override
    public void createProjectActivity(ProjectActivities projectActivities) {
        projectActivitiesRepository.save(projectActivities);
    }

    @Override
    public void updateProjectActivity(Long id, ProjectActivities projectActivities) {
        projectActivitiesRepository.deleteById(id);
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
