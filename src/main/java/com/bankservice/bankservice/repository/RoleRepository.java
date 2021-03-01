package com.bankservice.bankservice.repository;

import com.bankservice.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getByRoleName(Role.Roles name);
}
