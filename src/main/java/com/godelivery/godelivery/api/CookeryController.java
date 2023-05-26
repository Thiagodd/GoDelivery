package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import com.godelivery.godelivery.domain.service.RegisterCookeryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cookeries")
public class CookeryController {

    @Autowired
    private CookeryRepository cookeryRepository;

    @Autowired
    private RegisterCookeryService registerCookeryService;

    @GetMapping
    public List<Cookery> findAll() {
        return cookeryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cookery> findById(@PathVariable Long id) {
        Optional<Cookery> savedCookery = cookeryRepository.findById(id);
        return savedCookery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cookery> save(@RequestBody Cookery cookery) {
        Cookery savedCookery = registerCookeryService.save(cookery);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCookery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cookery> update(@PathVariable Long id, @RequestBody Cookery cookery) {
        Optional<Cookery> currentCookery = cookeryRepository.findById(id);

        if (currentCookery.isPresent()) {
            BeanUtils.copyProperties(cookery, currentCookery.get(), "id");
            Cookery savedCookery = registerCookeryService.update(currentCookery.get());
            return ResponseEntity.status(HttpStatus.OK).body(savedCookery);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            registerCookeryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }



}
