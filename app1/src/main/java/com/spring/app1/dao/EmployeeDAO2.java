package com.spring.app1.dao;

import com.spring.app1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO2 extends JpaRepository<Employee, Integer> {
    // Done
}
