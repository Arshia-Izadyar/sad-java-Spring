package com.spring.app1.dao;

import com.spring.app1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposatory extends JpaRepository<Employee, Integer> {
}
