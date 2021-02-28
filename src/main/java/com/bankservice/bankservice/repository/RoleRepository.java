package com.bankservice.bankservice.repository;

import com.bankservice.bankservice.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("FROM roles r WHERE r.roleName =:roleName")
    Optional<Role> getByRoleName(@Param("roleName") String roleName);
}
