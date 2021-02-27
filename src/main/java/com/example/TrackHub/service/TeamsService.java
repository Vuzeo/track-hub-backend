package com.example.TrackHub.service;

import com.example.TrackHub.model.Teams;

public interface TeamsService {

    public abstract void createTeam(Teams teams);

    public abstract void updateTeam(Long id, Teams teams);

    public abstract void deleteTeam(Long id);

    public abstract Object getTeams();
}
