package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class RoleDAOImpl implements IRoleDAO{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Role> findAll() {
        Query query = entityManager.createQuery("select r from Role  r");
        return query.getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findByName(String name) {
        return entityManager.getReference(Role.class, name);
    }

    @Override
    public void delete(Role role) {
        entityManager.remove(role);
    }
}
