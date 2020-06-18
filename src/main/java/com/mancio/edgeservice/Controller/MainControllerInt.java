package com.mancio.edgeservice.Controller;

import com.mancio.edgeservice.dto.EmployeesDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("301javamicro")
public interface MainControllerInt {

    @GetMapping("/employees")
    Iterable<EmployeesDto> findAll();
}
