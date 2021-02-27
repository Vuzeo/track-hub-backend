package com.example.TrackHub.service;

import org.springframework.stereotype.Service;

import com.example.TrackHub.model.Worklog;
import com.example.TrackHub.repository.WorklogRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorklogServiceImpl implements WorklogService {
    static WorklogRepository worklogRepository;

    public WorklogServiceImpl(WorklogRepository worklogRepository) {
        this.worklogRepository = worklogRepository;
    }

    @Override
    public void createWorklog(Worklog worklog) {
        worklogRepository.save(worklog);
    }

    @Override
    public void updateWorklog(Long id, Worklog worklog) {
        worklogRepository.deleteById(id);
        worklogRepository.save(worklog);
    }

    @Override
    public void deleteWorklog(Long id) {
        worklogRepository.deleteById(id);
    }

    @Override
    public List<Worklog> getWorklogs() {
        List<Worklog> worklogs = new ArrayList<Worklog>();
        worklogRepository.findAll().forEach(worklogs::add);
        return worklogs;
    }
}
