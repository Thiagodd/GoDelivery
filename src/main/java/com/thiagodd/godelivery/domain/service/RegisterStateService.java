package com.thiagodd.godelivery.domain.service;

import com.thiagodd.godelivery.domain.exception.EntityInUseException;
import com.thiagodd.godelivery.domain.exception.EntityNotFoundException;
import com.thiagodd.godelivery.domain.exception.StateNotFoundException;
import com.thiagodd.godelivery.domain.model.State;
import com.thiagodd.godelivery.domain.repository.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterStateService {

  public static final String MSG_STATE_NOT_FOUND = "Não foi possível encontrar a cozinha com o ID %d. Verifique se o ID fornecido está correto ou entre em contato com o suporte para obter assistência.";
  public static final String MSG_STATE_IN_USE = "Não foi possível excluir a cozinha com o ID %d. A cozinha está em uso e não pode ser deletada no momento.";

  private final StateRepository stateRepository;

  public RegisterStateService(StateRepository stateRepository) {
    this.stateRepository = stateRepository;
  }

  public List<State> findAll() {
    return stateRepository.findAll();
  }

  public State findById(Long id) {
    return stateRepository.findById(id)
        .orElseThrow(() -> new StateNotFoundException(id));
  }

  public State save(State newState) {
    return stateRepository.save(newState);
  }

  public State update(State newState) {
    State currentState = findById(newState.getId());
    BeanUtils.copyProperties(newState, currentState, "id");
    return stateRepository.save(newState);
  }

  public void deleteById(Long id) {
    if (!stateRepository.existsById(id)) {
      throw new StateNotFoundException(id);
    }

    try {
      stateRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new EntityInUseException(id, "estado");
    }
  }
}
