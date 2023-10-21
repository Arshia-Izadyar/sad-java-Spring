package com.spring.app1.service;

import com.spring.app1.dao.EmployeeReposatory;
import com.spring.app1.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

//    private final EmployeeDAO employeeDAO;
    private final EmployeeReposatory employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeReposatory employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
//    @Transactional JPA has this by default
    public Employee  save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public Employee find(int id) {
        Optional<Employee> emp = employeeDAO.findById(id);
        return emp.orElse(null);
    }

    @Override
    public List<Employee> findAll() {return employeeDAO.findAll();}

    @Override
    public List<Employee> find_by_name(String name) {
        // return employeeDAO.find_by_name(name);
//        employeeDAO.
        return null;
    }

    //    @Transactional JPA has this by default
    @Override
    public Employee update(Employee employee) {
//        employeeDAO.update(employee);
//        return find(employee.getId());
        return null;
    }

    //    @Transactional JPA has this by default
    @Override
    public int delete(int id) {
        Optional<Employee> emp = employeeDAO.findById(id);
        if (emp.isPresent()) {
            employeeDAO.delete(emp.get());
            return 1;
        } else {
            return 0;
        }
    }
}
