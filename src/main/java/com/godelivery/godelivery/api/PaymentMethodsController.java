package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.exception.EntityInUseException;
import com.godelivery.godelivery.domain.exception.EntityNotFoundException;
import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.model.PaymentMethods;
import com.godelivery.godelivery.domain.repository.PaymentMethodsRepository;
import com.godelivery.godelivery.domain.service.RegisterPaymentMethodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodsController {

    @Autowired
    private PaymentMethodsRepository paymentMethodsRepository;

    @Autowired
    private RegisterPaymentMethodsService registerPaymentMethodsService;

    @GetMapping
    public List<PaymentMethods> findAll() {
        return paymentMethodsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethods> findById(@PathVariable Long id) {
        Optional<PaymentMethods> savedPaymentMethods = paymentMethodsRepository.findById(id);
        return savedPaymentMethods.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PaymentMethods> save(@RequestBody PaymentMethods paymentMethods) {
        PaymentMethods savedPaymentMethods = registerPaymentMethodsService.save(paymentMethods);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaymentMethods);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethods> update(@PathVariable Long id, @RequestBody Cookery cookery) {
        Optional<PaymentMethods> currentPaymentMethods= paymentMethodsRepository.findById(id);

        if (currentPaymentMethods.isPresent()) {
            BeanUtils.copyProperties(cookery, currentPaymentMethods.get(), "id");
            PaymentMethods savedPaymentMethods = registerPaymentMethodsService.update(currentPaymentMethods.get());
            return ResponseEntity.status(HttpStatus.OK).body(savedPaymentMethods);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            registerPaymentMethodsService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
