package com.spring.app1.dao;

import com.spring.app1.entity.Employee;
import com.spring.app1.entity.Student;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee employee);
    Employee find(int id);
    List<Employee> findAll();
    List<Employee> find_by_name(String name);
    void update(Employee employee);
    int delete(int id);
}
