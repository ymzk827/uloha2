package com.example.uloha2.dao;

import java.util.List;
import com.example.uloha2.entity.Employee;

public interface EmployeeDAO {
    List<Employee> findAll();
}
