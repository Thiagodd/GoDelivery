package com.thiagodd.godelivery.api;

import com.thiagodd.godelivery.domain.model.Cookery;
import com.thiagodd.godelivery.domain.service.RegisterCookeryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cookeries")
public class CookeryController {

  private final RegisterCookeryService registerCookeryService;

  public CookeryController(RegisterCookeryService registerCookeryService) {
    this.registerCookeryService = registerCookeryService;
  }

  @GetMapping
  public List<Cookery> findAll() {
    return registerCookeryService.findAll();
  }

  @GetMapping("/{id}")
  public Cookery findById(@PathVariable Long id) {
    return registerCookeryService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cookery save(@RequestBody Cookery cookery) {
    return registerCookeryService.save(cookery);
  }

  @PutMapping("/{id}")
  public Cookery update(@PathVariable Long id, @RequestBody Cookery newCookery) {
    newCookery.setId(id);
    return registerCookeryService.update(newCookery);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) {
    registerCookeryService.deleteById(id);
  }

}
