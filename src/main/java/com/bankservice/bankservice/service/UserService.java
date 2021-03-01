package com.bankservice.bankservice.service;

import com.bankservice.bankservice.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    void delete(Long id);

    User getById(Long id);

    User getByPhone(String phoneNumber);

    List<User> getAll();
}
