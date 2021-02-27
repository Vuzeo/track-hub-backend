package com.example.TrackHub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.TrackHub.model.ProjectActivities;
import com.example.TrackHub.repository.ProjectActivitiesRepository;
import com.example.TrackHub.service.ProjectActivitiesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/projectActivities")
public class ProjectActivitiesController {

    private ProjectActivitiesRepository projectActivitiesRepository;
    private ProjectActivitiesService projectActivitiesService;

    public ProjectActivitiesController(ProjectActivitiesService projectActivitiesService) {
        this.projectActivitiesService = projectActivitiesService;
    }

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> getProjectActivities() {
        return new ResponseEntity<>(projectActivitiesService.getProjectActivities(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>
    updateProjectActivity(@PathVariable("id") Long id, @RequestBody ProjectActivities projectActivities) {
        projectActivitiesService.updateProjectActivity(id, projectActivities);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProjectActivity(@PathVariable("id") Long id) {
        projectActivitiesService.deleteProjectActivity(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> createProjectActivity(@RequestBody ProjectActivities projectActivities) {
        projectActivitiesService.createProjectActivity(projectActivities);
        return new ResponseEntity<>(projectActivities, HttpStatus.OK);
    }
}
