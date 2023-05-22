package com.godelivery.godelivery.domain.repository;

import com.godelivery.godelivery.domain.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository {

    List<Permission> findAll();
    Permission findById(Long id);
    Permission insert(Permission permission);
    Permission update(Permission permission);
    void remove (Permission permission);

}
