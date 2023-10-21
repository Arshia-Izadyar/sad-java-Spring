package com.spring.app1.service;

import com.spring.app1.entity.Employee;
import com.spring.app1.entity.Response;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee find(int id);
    List<Employee> findAll();
    List<Employee> find_by_name(String name);
    Employee update(Employee employee);
    int delete(int id);
}
