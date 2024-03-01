package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Role getByName(String name) {
        return entityManager.createQuery("from Role where role=:name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        entityManager.remove(getById(id));
    }
}
