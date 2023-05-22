package com.godelivery.godelivery.api;

import com.godelivery.godelivery.domain.model.Cookery;
import com.godelivery.godelivery.domain.repository.CookeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cookeries")
public class CookeryController {

    @Autowired
    private CookeryRepository cookeryRepository;

    @GetMapping
    public List<Cookery> findAll(){
        return cookeryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cookery findById(@PathVariable Long id){
        return cookeryRepository.findById(id);
    }
}
