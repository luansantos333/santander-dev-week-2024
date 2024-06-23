package me.dio.domain.service.Impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service

public class UserServiceImpl implements UserService {


    @Autowired
    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {


        if (user.getId()!=null && userRepository.existsById(user.getId())) throw new IllegalArgumentException("This user ID already exists!");

        return userRepository.save(user);
    }

    @Override
    public void deletUserById(Long id) {


        userRepository.deleteById(id);

    }

    @Override
    public User updateUser(Long id, User user) {

        if (userRepository.existsById(id)) {


           return userRepository.save(user);

        } else {

            return null;

        }

    }
}
