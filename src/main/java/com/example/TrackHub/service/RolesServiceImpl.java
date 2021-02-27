package com.example.TrackHub.service;

import org.springframework.stereotype.Service;

import com.example.TrackHub.model.Roles;
import com.example.TrackHub.repository.RolesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void createRole(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void updateRole(Long id, Roles roles) {
        rolesRepository.deleteById(id);
        rolesRepository.save(roles);
    }

    @Override
    public void deleteRole(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public List<Roles> getRoles() {
        List<Roles> roles = new ArrayList<Roles>();
        rolesRepository.findAll().forEach(roles::add);
        return roles;
    }
}
