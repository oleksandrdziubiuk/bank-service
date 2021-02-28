package com.bankservice.bankservice.service;

import com.bankservice.bankservice.model.Role;
import java.util.Optional;

public interface RoleService {
    Role save(Role role);

    Optional<Role> getByName(String roleName);
}
