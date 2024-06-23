package me.dio.domain.service;

import me.dio.domain.model.User;

public interface UserService {

    User findById(Long id);

    Iterable<User> findAll();

    User createUser(User user);

    void deletUserById(Long id);

    User updateUser(Long id, User user);





}
