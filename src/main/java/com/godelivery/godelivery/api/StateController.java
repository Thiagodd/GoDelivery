package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.State;
import com.godelivery.godelivery.domain.repository.StateRepository;
import com.godelivery.godelivery.domain.service.RegisterStateService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private RegisterStateService registerStateService;

    @GetMapping
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        Optional<State> savedState = stateRepository.findById(id);
        return savedState.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<State> save(@RequestBody State state) {
        State savedState = registerStateService.save(state);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedState);
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> update(@PathVariable Long id, @RequestBody State newState){
        Optional<State> existingState = stateRepository.findById(id);

        if (existingState.isPresent()){
            BeanUtils.copyProperties(newState, existingState.get(), "id");
            State updatedState = registerStateService.update(existingState.get());
            return ResponseEntity.ok(updatedState);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
            registerStateService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (EntityInUseException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }




}
