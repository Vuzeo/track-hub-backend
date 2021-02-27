package com.example.TrackHub.service;

import com.example.TrackHub.model.Roles;

public interface RolesService {

    public abstract void createRole(Roles roles);

    public abstract void updateRole(Long id, Roles roles);

    public abstract void deleteRole(Long id);

    public abstract Object getRoles();
}
