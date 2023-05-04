package com.magadiflo.jdbc.template.app.service;

import com.magadiflo.jdbc.template.app.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> update(Long id, User user);

    Optional<Boolean> deleteById(Long id);
}
