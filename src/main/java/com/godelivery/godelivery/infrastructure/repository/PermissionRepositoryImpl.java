package com.godelivery.godelivery.infrastructure.repository;

import com.godelivery.godelivery.domain.model.Permission;
import com.godelivery.godelivery.domain.repository.PermissionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PermissionRepositoryImpl implements PermissionRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Permission> findAll() {
        TypedQuery<Permission> typedQuery = entityManager.createQuery("from Permission", Permission.class);
        return typedQuery.getResultList();
    }

    @Override
    public Permission findById(Long id) {
        return entityManager.find(Permission.class, id);
    }

    @Override
    @Transactional
    public Permission insert(Permission permission) {
        return entityManager.merge(permission);
    }

    @Override
    @Transactional
    public Permission update(Permission permission) {
        return entityManager.merge(permission);
    }

    @Override
    @Transactional
    public void remove(Permission permission) {
        Permission currentCity = this.findById(permission.getId());
        entityManager.remove(currentCity);
    }
}
