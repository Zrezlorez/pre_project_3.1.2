package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.Authentication;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    User getByName(String name);
    void add(User user);
    void delete(Long id);
    void update(User user);
    List<User> findAll();
    User getUserByAuth(Authentication authentication);
}
