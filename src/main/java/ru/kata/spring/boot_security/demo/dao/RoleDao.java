package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDao {

    Role getById(Long id);

    Role getByName(String name);

    void add(Role role);

    void deleteById(Long id);

    List<Role> findAll();
}