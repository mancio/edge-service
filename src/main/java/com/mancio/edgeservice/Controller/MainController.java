package com.mancio.edgeservice.Controller;

import com.mancio.edgeservice.dto.EmployeesDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final MainControllerInt mainControllerInt;

    public MainController(MainControllerInt mainControllerInt) {
        this.mainControllerInt = mainControllerInt;
    }


    @GetMapping("/employees")
    Iterable<EmployeesDto> findAll(){
        return mainControllerInt.findAll();
    }
}
