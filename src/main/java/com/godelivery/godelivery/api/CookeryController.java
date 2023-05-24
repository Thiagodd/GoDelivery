package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import com.godelivery.godelivery.domain.service.RegisterCookeryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Cookery savedCookery = cookeryRepository.findById(id);
        if (savedCookery != null) {
            return ResponseEntity.status(HttpStatus.OK).body(savedCookery);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Cookery> insert(@RequestBody Cookery cookery) {
        Cookery savedCookery = registerCookeryService.insert(cookery);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCookery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cookery> update(@PathVariable Long id, @RequestBody Cookery cookery) {
        Cookery currentCookery = cookeryRepository.findById(id);

        if (currentCookery != null) {
            BeanUtils.copyProperties(cookery, currentCookery, "id");
            currentCookery = cookeryRepository.update(currentCookery);
            return ResponseEntity.status(HttpStatus.OK).body(currentCookery);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            registerCookeryService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


}
