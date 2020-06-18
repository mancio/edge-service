package com.mancio.edgeservice.dto;

import lombok.Data;

@Data
public class EmployeesDto {
    private long employee_id;
    private String employee_name;
    private String employee_last_name;
    private String employee_address;
    private String employee_phone;
    private String job_position;
    private int salary;
    private String currency;
}
