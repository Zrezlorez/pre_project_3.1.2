package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    void add(Role role);

    Role findById(Long id);

    List<Role> findAll();

    Role findByName(String name);

    void deleteById(Long id);
}
