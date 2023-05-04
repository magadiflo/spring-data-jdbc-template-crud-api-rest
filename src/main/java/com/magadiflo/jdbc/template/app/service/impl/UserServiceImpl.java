package com.magadiflo.jdbc.template.app.service.impl;

import com.magadiflo.jdbc.template.app.model.User;
import com.magadiflo.jdbc.template.app.repository.IUserRepository;
import com.magadiflo.jdbc.template.app.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        Long id = this.userRepository.saveAndReturnId(user);
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public Optional<User> update(Long id, User user) {
        return this.userRepository.findById(id)
                .map(userDB -> {
                    User userToUpdate = new User(
                            userDB.id(),
                            user.firstName(),
                            user.lastName(),
                            user.email()
                    );
                    this.userRepository.update(userToUpdate);
                    return this.userRepository.findById(userDB.id());
                })
                .orElseGet(Optional::empty);
    }

    @Override
    @Transactional
    public Optional<Boolean> deleteById(Long id) {
        return this.userRepository.findById(id)
                .map(userDB -> {
                    this.userRepository.deleteById(id);
                    return Optional.of(true);
                })
                .orElseGet(Optional::empty);
    }
}
