package com.example.uloha2.service;

import java.util.List;
import com.example.uloha2.entity.Employee;
import jakarta.transaction.Transactional;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    @Transactional
    Employee save(Employee employee);

    @Transactional
    Employee deleteById(Integer id);

    List<Employee> getSortedEmployees();
}
