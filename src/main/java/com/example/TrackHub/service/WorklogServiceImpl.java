package com.example.TrackHub.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.TrackHub.model.Worklog;
import com.example.TrackHub.repository.WorklogRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorklogServiceImpl implements WorklogService {
    private final WorklogRepository worklogRepository;

    public WorklogServiceImpl(WorklogRepository worklogRepository) {
        this.worklogRepository = worklogRepository;
    }

    @Override
    public void createWorklog(Worklog worklog) {
        worklogRepository.save(worklog);
    }

    @Override
    public void updateWorklog(Long id, Worklog worklog) {
        if (!worklogRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Save under the path id so the row is updated in place and keeps its foreign keys
        worklog.setId(id);
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
