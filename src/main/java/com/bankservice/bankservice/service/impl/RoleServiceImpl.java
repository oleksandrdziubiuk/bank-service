package com.bankservice.bankservice.service.impl;

import com.bankservice.bankservice.exception.DataProcessingException;
import com.bankservice.bankservice.model.Role;
import com.bankservice.bankservice.repository.RoleRepository;
import com.bankservice.bankservice.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return repository.getByRoleName(Role.Roles.valueOf(roleName)).orElseThrow(
                () -> new DataProcessingException("Can't get role by name " + roleName));
    }
}
