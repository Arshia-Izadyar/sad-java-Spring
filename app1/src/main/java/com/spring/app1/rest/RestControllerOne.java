package com.spring.app1.rest;


import com.spring.app1.common.Coach;
import com.spring.app1.dao.StudentDAO;
import com.spring.app1.entity.Response;
import com.spring.app1.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestControllerOne {
    // legacy

    //  @Autowired
    // private @Qualifier("basketballCoach") Coach myCoach;
    private Coach myCoach;
    private StudentDAO s;

    // constructor for dependency injection
    @Autowired
    public RestControllerOne(@Qualifier("swimCoach") Coach c, @Qualifier("studentDAOImpl") StudentDAO s) {
        myCoach = c;
        this.s = s;
    }




    @GetMapping(value = "/{id}")
    public Response<Student> hello(@PathVariable int id) {
        Optional<Student> students = Optional.ofNullable(s.find(id));
        if (students.isPresent()) {

            return Response.create(students.get(), 200);
        } else {
            throw new StudentNotFound("not found");
        }

        // return Response.create(null , 404);
    }
}
