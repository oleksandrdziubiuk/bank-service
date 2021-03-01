package com.bankservice.bankservice.repository;

import com.bankservice.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM users u JOIN FETCH u.roles WHERE u.phoneNumber =:phoneNumber")
    Optional<User> getByPhoneNumber(String phoneNumber);

    @Query("FROM users u JOIN FETCH u.roles WHERE u.id =:id")
    Optional<User> getById(Long id);
}
