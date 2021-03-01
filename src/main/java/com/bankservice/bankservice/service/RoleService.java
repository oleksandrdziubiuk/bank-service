package com.bankservice.bankservice.service;

import com.bankservice.bankservice.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String roleName);
}
