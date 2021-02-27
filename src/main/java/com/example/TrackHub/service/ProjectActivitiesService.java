package com.example.TrackHub.service;

import com.example.TrackHub.model.ProjectActivities;

public interface ProjectActivitiesService {

    public abstract void createProjectActivity(ProjectActivities projectActivities);

    public abstract void updateProjectActivity(Long id, ProjectActivities projectActivities);

    public abstract void deleteProjectActivity(Long id);

    public abstract Object getProjectActivities();
}
