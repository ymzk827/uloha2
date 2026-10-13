package com.example.uloha2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.uloha2.dao.EmployeeDAO;
import com.example.uloha2.entity.Employee;

import java.util.List;

@Service
public class ServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public ServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
