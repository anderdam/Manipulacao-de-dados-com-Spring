package com.challenge.service;

import com.challenge.entity.User;

import java.util.List;
import java.util.Optional;

public class UserServiceInterface implements com.challenge.service.interfaces.UserServiceInterface {
    @Override
    public Optional<User> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return null;
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return null;
    }

    @Override
    public User save(User object) {
        return null;
    }
}
