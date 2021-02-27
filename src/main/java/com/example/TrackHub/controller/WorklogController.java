package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.Worklog;
import com.example.TrackHub.repository.WorklogRepository;
import com.example.TrackHub.service.WorklogService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/worklog")
public class WorklogController {

    private WorklogRepository worklogRepository;
    private WorklogService worklogService;

    public WorklogController(WorklogService worklogService) {
        this.worklogService = worklogService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getWorklogs() {
        return new ResponseEntity<>(worklogService.getWorklogs(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateWorklog(@PathVariable("id") Long id, @RequestBody Worklog worklog) {
        worklogService.updateWorklog(id, worklog);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteWorklog(@PathVariable("id") Long id) {
        worklogService.deleteWorklog(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createWorklog(@RequestBody Worklog worklog) {
        worklogService.createWorklog(worklog);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.OK);
    }
}
