package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao  {
    User getById(Long id);
    User getByName(String name);
    void add(User user);
    void delete(Long Id);
    void update(User user);
    List<User> getAllUsers();
}
