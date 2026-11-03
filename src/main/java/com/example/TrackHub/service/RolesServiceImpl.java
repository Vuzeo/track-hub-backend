package com.example.TrackHub.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.TrackHub.model.Roles;
import com.example.TrackHub.repository.RolesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void createRole(Roles roles) {
        rolesRepository.save(roles);
    }

    @Override
    public void updateRole(Long id, Roles roles) {
        if (!rolesRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        // Save under the path id so the row is updated in place and keeps its foreign keys
        roles.setId(id);
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
