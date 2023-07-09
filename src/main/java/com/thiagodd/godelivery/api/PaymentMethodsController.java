package com.thiagodd.godelivery.api;

import com.thiagodd.godelivery.domain.model.PaymentMethod;
import com.thiagodd.godelivery.domain.service.RegisterPaymentMethodsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodsController {

 private final RegisterPaymentMethodsService registerPaymentMethodsService;

 public PaymentMethodsController(RegisterPaymentMethodsService registerPaymentMethodsService) {
  this.registerPaymentMethodsService = registerPaymentMethodsService;
 }

 @GetMapping
 public List<PaymentMethod> findAll() {
  return registerPaymentMethodsService.findAll();
 }

 @GetMapping("/{id}")
 public PaymentMethod findById(@PathVariable Long id) {
  return registerPaymentMethodsService.findById(id);
 }

 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
 public PaymentMethod insert(@RequestBody PaymentMethod paymentMethod) {
  return registerPaymentMethodsService.insert(paymentMethod);
 }

 @PutMapping("/{id}")
 public PaymentMethod update(@PathVariable Long id, @RequestBody PaymentMethod newPaymentMethod) {
  newPaymentMethod.setId(id);
  return registerPaymentMethodsService.update(newPaymentMethod);
 }

 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void deleteById(@PathVariable Long id) {
  registerPaymentMethodsService.deleteById(id);
 }
}
