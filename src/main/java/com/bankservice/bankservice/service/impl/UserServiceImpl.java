package com.bankservice.bankservice.service.impl;

import com.bankservice.bankservice.exception.DataProcessingException;
import com.bankservice.bankservice.model.User;
import com.bankservice.bankservice.repository.UserRepository;
import com.bankservice.bankservice.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id).orElseThrow(
                () -> new DataProcessingException("Can't get user by id " + id));
    }

    @Override
    public User getByPhone(String phoneNumber) {
        return userRepository.getByPhoneNumber(phoneNumber).orElseThrow(
                () -> new DataProcessingException("Can't get user by phone number " + phoneNumber));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
