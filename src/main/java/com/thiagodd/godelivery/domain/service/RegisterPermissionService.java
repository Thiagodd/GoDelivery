package com.thiagodd.godelivery.domain.service;

import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.exception.EntityNotFoundException;
import com.thiagodd.godelivery.domain.exception.PermissionNotFoundException;
import com.thiagodd.godelivery.domain.model.Permission;
import com.thiagodd.godelivery.domain.repository.PermissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterPermissionService {

  String MSG_PERMISSION_NOT_FOUND = ">>Não foi possível encontrar a permissão com o ID %d. Verifique se o ID fornecido está correto ou entre em contato com o suporte para obter assistência.";
  String MSG_PERMISSION_IN_USE = "Não foi possível excluir a permissão com o ID %d. A cidade está em uso e não pode ser removido no momento.";

  private final PermissionRepository permissionRepository;

  public RegisterPermissionService(PermissionRepository permissionRepository) {
    this.permissionRepository = permissionRepository;
  }

  public List<Permission> findAll() {
    return permissionRepository.findAll();
  }

  public Permission findById(Long id) {
    return permissionRepository.findById(id)
        .orElseThrow(() -> new PermissionNotFoundException(id));
  }

  public Permission insert(Permission permission) {
    return permissionRepository.save(permission);
  }

  public Permission update(Permission newPermission) {
    Permission currentPermission = findById(newPermission.getId());
    BeanUtils.copyProperties(newPermission, currentPermission, "id");
    return permissionRepository.save(newPermission);
  }

  public void deleteById(Long id) {
    if (!permissionRepository.existsById(id)) {
      throw new PermissionNotFoundException(id);
    }
    try {
      permissionRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new EntityInUseException(id, "permissão");
    }
  }
}
