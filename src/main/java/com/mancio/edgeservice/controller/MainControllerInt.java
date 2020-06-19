package com.mancio.edgeservice.controller;

import com.mancio.edgeservice.dto.EmployeesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient("301javamicro")
public interface MainControllerInt {
    @GetMapping("/employees")
    Iterable<EmployeesDto> findAll();
    @GetMapping("/employees/{id}")
    Optional<EmployeesDto> findById(@PathVariable(value = "id") Long id);
    @PostMapping("/employees")
    EmployeesDto save(@Valid @RequestBody EmployeesDto emp);
    @DeleteMapping("/employees/{id}")
    void deleteById(@PathVariable(value = "id") Long id);
}
