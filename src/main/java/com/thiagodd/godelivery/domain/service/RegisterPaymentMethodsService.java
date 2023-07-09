package com.thiagodd.godelivery.domain.service;

import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.exception.PaymentMethodNotFound;
import com.thiagodd.godelivery.domain.model.PaymentMethod;
import com.thiagodd.godelivery.domain.repository.PaymentMethodsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterPaymentMethodsService {

 private static final String MSG_PAYMENT_METHOD_NOT_FOUND = ">>Não foi possível encontrar o método de pagamento com o ID %d. Verifique se o ID fornecido está correto ou entre em contato com o suporte para obter assistência.";
 private static final String MSG_PAYMENT_METHOD_IN_USE = "Não foi possível excluir o método de pagamento com o ID %d. A cidade está em uso e não pode ser removido no momento.";

 private final PaymentMethodsRepository paymentMethodsRepository;

 public RegisterPaymentMethodsService(PaymentMethodsRepository paymentMethodsRepository) {
  this.paymentMethodsRepository = paymentMethodsRepository;
 }

 public List<PaymentMethod> findAll() {
  return paymentMethodsRepository.findAll();
 }

 public PaymentMethod findById(Long id) {
  return paymentMethodsRepository.findById(id)
      .orElseThrow(() -> new PaymentMethodNotFound(id));
 }

 public PaymentMethod insert(PaymentMethod paymentMethod) {
  return paymentMethodsRepository.save(paymentMethod);
 }

 public PaymentMethod update(PaymentMethod newPaymentMethod) {
  PaymentMethod currentPaymentMethod = findById(newPaymentMethod.getId());
  BeanUtils.copyProperties(newPaymentMethod, currentPaymentMethod, "id");
  return paymentMethodsRepository.save(newPaymentMethod);
 }

 public void deleteById(Long id) {
  if (!paymentMethodsRepository.existsById(id)) {
   throw new PaymentMethodNotFound(id);
  }

  try {
   paymentMethodsRepository.deleteById(id);
  } catch (DataIntegrityViolationException e) {
   throw new EntityInUseException(id, "método de pagamento");
  }
 }

}

