package com.example.TrackHub.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.TrackHub.model.Teams;
import com.example.TrackHub.repository.TeamsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamsServiceImpl implements TeamsService {

    private final TeamsRepository teamsRepository;

    public TeamsServiceImpl(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }

    @Override
    public void createTeam(Teams teams) {
        teamsRepository.save(teams);
    }

    @Override
    public void updateTeam(Long id, Teams teams) {
        if (!teamsRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Save under the path id so the row is updated in place and keeps its foreign keys
        teams.setId(id);
        teamsRepository.save(teams);
    }

    @Override
    public void deleteTeam(Long id) {
        teamsRepository.deleteById(id);
    }

    @Override
    public List<Teams> getTeams() {
        List<Teams> teams = new ArrayList<Teams>();
        teamsRepository.findAll().forEach(teams::add);
        return teams;
    }
}
