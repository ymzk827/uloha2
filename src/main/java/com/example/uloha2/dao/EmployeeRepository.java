package com.example.uloha2.dao;

import com.example.uloha2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastNameAsc();
    //Optional<Employee> findById(Integer id);
}
