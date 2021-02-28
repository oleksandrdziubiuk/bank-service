package com.bankservice.bankservice.service;

import com.bankservice.bankservice.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);

    User update(User user);

    void delete(Long id);

    Optional<User> getById(Long id);

    Optional<User> getByPhone(String phoneNumber);

    List<User> getAll();
}
