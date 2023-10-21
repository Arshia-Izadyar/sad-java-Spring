package com.spring.app1.rest;

import com.spring.app1.dao.EmployeeDAO;
import com.spring.app1.dao.EmployeeDAOImpl;
import com.spring.app1.entity.Employee;
import com.spring.app1.entity.Response;
import com.spring.app1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
@RestController
@RequestMapping("/emp")
public class RestControllerEmployee {

    private EmployeeService employeeService;

    @Autowired
    public RestControllerEmployee(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public Response<Employee> get(@PathVariable int id){
        Optional<Employee> emp = Optional.ofNullable(employeeService.find(id));
        if (emp.isPresent()) {

            return Response.create(emp.get(), 200);
        } else {
            throw new StudentNotFound("not found");
        }
    }

    @GetMapping("/")
    public List<Employee> all(){
        return employeeService.findAll();
    }

//    @GetMapping("/u/{username}")
//    public List<Employee> getByUsername(@PathVariable String username){
//        return employeeService.find_by_name(username);
//    }


    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        employee.setId(0); // to save
        return employeeService.save(employee);
    }

//    @PutMapping("/update") // TODO: add update with id
//    public Employee update(@RequestBody Employee employee){
//        return employeeService.update(employee);
//    }


    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable int id){
        int success = employeeService.delete(id);
        if (success == 0) {
            return Response.create("Not found ", 404);

        } return Response.create("Deleted", HttpStatus.NO_CONTENT.value());
    }

}
*/
public class RestControllerEmployee {



}