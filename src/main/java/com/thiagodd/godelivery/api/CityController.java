package com.thiagodd.godelivery.api;

import com.thiagodd.godelivery.domain.exception.BusinessException;
import com.thiagodd.godelivery.domain.exception.StateNotFoundException;
import com.thiagodd.godelivery.domain.model.City;
import com.thiagodd.godelivery.domain.service.RegisterCityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final RegisterCityService registerCityService;

    public CityController(RegisterCityService registerCityService) {
        this.registerCityService = registerCityService;
    }

    @GetMapping
    public List<City> findAll() {
        return registerCityService.findAll();
    }

    @GetMapping("/{id}")
    private City findById(@PathVariable Long id) {
        return registerCityService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City insert(@RequestBody City newCity) {
        try {
            return registerCityService.save(newCity);
        } catch (StateNotFoundException exception) {
            throw new BusinessException(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City newCity) {
        try {
            newCity.setId(id);
            return registerCityService.update(newCity);
        } catch (StateNotFoundException exception) {
            throw new BusinessException(exception.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        registerCityService.deleteById(id);
    }

}
