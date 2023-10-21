package com.spring.app1.dao;

import com.spring.app1.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    EntityManager entityManager;


    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee); // if id == 0 merge will create and if id < 0 it will update
    }

    @Override
    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> q = entityManager.createQuery("FROM Employee", Employee.class);
        return q.getResultList();
    }

    @Override
    public List<Employee> find_by_name(String name) {
        TypedQuery<Employee> q = entityManager.createQuery("FROM Employee Where firstName = :name", Employee.class);
        q.setParameter("name", name);
        return q.getResultList();
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override // if we use DAO and Service to gather Service layer should be responsible for transaction
    public int delete(int id) {
        Optional<Employee> emp = Optional.ofNullable(entityManager.find(Employee.class, id));
        if (emp.isPresent()) {
            entityManager.remove(emp);
            return 1;
        } else {
            return 0;
        }
    }
}
