package com.bankservice.bankservice.repository;

import com.bankservice.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM users u JOIN FETCH u.roles WHERE u.phoneNumber =:phoneNumber")
    Optional<User> getByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
