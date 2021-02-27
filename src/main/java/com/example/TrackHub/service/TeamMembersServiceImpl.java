package com.example.TrackHub.service;

import org.springframework.stereotype.Service;

import com.example.TrackHub.model.TeamMembers;
import com.example.TrackHub.repository.TeamMembersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMembersServiceImpl implements TeamMembersService {
    TeamMembersRepository teamMembersRepository;

    public TeamMembersServiceImpl(TeamMembersRepository teamMembersRepository) {
        this.teamMembersRepository = teamMembersRepository;
    }

    @Override
    public List<TeamMembers> getTeamMembers() {
        List<TeamMembers> teamMembers = new ArrayList<TeamMembers>();
        teamMembersRepository.findAll().forEach(teamMembers::add);
        return teamMembers;
    }

    @Override
    public void createTeamMembers(TeamMembers teamMembers) {
        teamMembersRepository.save(teamMembers);
    }

    @Override
    public void updateTeamMembers(Long id, TeamMembers teamMembers) {
        teamMembersRepository.deleteById(id);
        teamMembersRepository.save(teamMembers);
    }

    @Override
    public void deleteTeamMembers(Long id) {
        teamMembersRepository.deleteById(id);
    }
}
