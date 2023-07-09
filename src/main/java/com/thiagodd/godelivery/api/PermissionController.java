package com.thiagodd.godelivery.api;

import com.thiagodd.godelivery.domain.model.Permission;
import com.thiagodd.godelivery.domain.service.RegisterPermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {


 private final RegisterPermissionService registerPermissionService;

 public PermissionController(RegisterPermissionService registerPermissionService) {
  this.registerPermissionService = registerPermissionService;
 }

 @GetMapping
 public List<Permission> findAll() {
  return registerPermissionService.findAll();
 }

 @GetMapping("/{id}")
 public Permission findById(@PathVariable Long id) {
  return registerPermissionService.findById(id);
 }

 @PostMapping
 public Permission insert(@RequestBody Permission newPermission) {
  return registerPermissionService.insert(newPermission);
 }

 @PutMapping("/{id}")
 public Permission update(@PathVariable Long id, @RequestBody Permission newPermission) {
  newPermission.setId(id);
  return registerPermissionService.update(newPermission);
 }

 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void deleteById(@PathVariable Long id) {
  registerPermissionService.deleteById(id);
 }

}
