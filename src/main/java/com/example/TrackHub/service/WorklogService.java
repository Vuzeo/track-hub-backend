package com.example.TrackHub.service;

import com.example.TrackHub.model.Worklog;

public interface WorklogService {

    public abstract void createWorklog(Worklog worklog);

    public abstract void updateWorklog(Long id, Worklog worklog);

    public abstract void deleteWorklog(Long id);

    public abstract Object getWorklogs();
}
