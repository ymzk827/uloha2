package com.example.uloha2.service;

import com.example.uloha2.dao.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uloha2.entity.Employee;

import java.util.List;

@Service
public class ServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee deleteById(Integer id) {
        employeeRepository.deleteById(id);
        return null;
    }

    @Override
    public List<Employee> getSortedEmployees(){return employeeRepository.findAllByOrderByLastNameAsc();}
}
