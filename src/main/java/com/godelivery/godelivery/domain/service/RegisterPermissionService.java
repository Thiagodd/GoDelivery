package com.godelivery.godelivery.domain.service;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Permission;
import com.godelivery.godelivery.domain.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class RegisterPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    public Permission update(Permission permission) {
        return permissionRepository.save(permission);
    }

    public void deleteById(Long id) {
        if (!permissionRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format(">>No Permission record found with ID %d.", id));
        }
        try {
            permissionRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(">>Permission with ID %d cannot be deleted as it is currently in use.", id));
        }
    }
}
