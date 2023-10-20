package com.spring.app1.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerOne {

    private Coach myCoach;

    // constructor for dependency injection
    @Autowired
    public RestControllerOne(Coach c){
        myCoach =c;
    }


    @GetMapping("/workout")
    public String hello(){
        return myCoach.dailyWorkout();
    }
}
