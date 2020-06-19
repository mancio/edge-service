package com.mancio.edgeservice.controller;

import com.mancio.edgeservice.customExceptions.CustomNotFound;
import com.mancio.edgeservice.dto.EmployeesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MainController {

    private final MainControllerInt mainControllerInt;

    public MainController(MainControllerInt mainControllerInt) {
        this.mainControllerInt = mainControllerInt;
    }


    @GetMapping("/")
    public String welcome(){
        return "Welcome to the 301 Java Microservice!";
    }
    @GetMapping("/employees")
    public List<EmployeesDto> getAllEmployees(){
        return (List<EmployeesDto>) mainControllerInt.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<EmployeesDto>> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        Optional<EmployeesDto> empl = mainControllerInt.findById(employeeId);
        if(!empl.isPresent()){
            throw new CustomNotFound(employeeId);
        }
        else return ResponseEntity.ok().body(empl);





    }

    @PostMapping("/employees")
    public EmployeesDto createEmployee(@Valid @RequestBody EmployeesDto employee) {
        return mainControllerInt.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public Map< String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        try{
            mainControllerInt.deleteById(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomNotFound(employeeId);
        }
        Map < String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
