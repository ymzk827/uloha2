package com.example.uloha2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.uloha2.entity.Employee;
import com.example.uloha2.service.EmployeeService;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final EmployeeService eService;

    @Autowired
    public RestController(EmployeeService eService){this.eService = eService;}

    @GetMapping("/employees")
    public  List<Employee> getAllEmployees() {return eService.findAll();}

}
