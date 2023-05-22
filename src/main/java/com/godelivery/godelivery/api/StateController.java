package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.model.State;
import com.godelivery.godelivery.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @GetMapping
    public List<State> findAll(){
        return stateRepository.findAll();
    }
}
