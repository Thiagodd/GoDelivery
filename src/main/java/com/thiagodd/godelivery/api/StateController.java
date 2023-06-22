package com.thiagodd.godelivery.api;

import com.thiagodd.godelivery.domain.model.State;
import com.thiagodd.godelivery.domain.service.RegisterStateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

  private final RegisterStateService registerStateService;

  public StateController(RegisterStateService registerStateService) {
    this.registerStateService = registerStateService;
  }

  @GetMapping
  public List<State> findAll() {
    return registerStateService.findAll();
  }

  @GetMapping("/{id}")
  public State findById(@PathVariable Long id) {
    return registerStateService.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public State save(@RequestBody State state) {
    return registerStateService.save(state);
  }

  @PutMapping("/{id}")
  public State update(@PathVariable Long id, @RequestBody State newState) {
    newState.setId(id);
    return registerStateService.update(newState);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(@PathVariable Long id) {
    registerStateService.deleteById(id);
  }
}
