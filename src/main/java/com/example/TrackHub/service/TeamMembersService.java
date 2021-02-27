package com.example.TrackHub.service;

import com.example.TrackHub.model.TeamMembers;

public interface TeamMembersService {

    public abstract Object getTeamMembers();

    public abstract void createTeamMembers(TeamMembers teamMembers);

    public abstract void updateTeamMembers(Long id, TeamMembers teamMembers);

    public abstract void deleteTeamMembers(Long id);
}
