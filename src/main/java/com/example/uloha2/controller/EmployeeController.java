package com.example.uloha2.controller;

import com.example.uloha2.dao.EmployeeRepository;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.uloha2.entity.Employee;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        Employee x = repository.findById(id).orElse(null);

        if(x == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found: " + id);
        }
        return x;
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        employee.setId(null);
        return repository.save(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @Valid @RequestBody Employee employee){
        Employee existingEmployee = repository.findById(id).orElse(null);

        if(existingEmployee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found: " + id);
        }

        employee.setId(id);
        return repository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer id){
        Employee existingEmployee = repository.findById(id).orElse(null);

        if(existingEmployee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee ID not found: " + id);
        }

        repository.deleteById(id);
    }

    @GetMapping("/employees/sorted")
    public List<Employee> getSortedEmployees() {
        return repository.findAllByOrderByLastNameAsc();
    }
}