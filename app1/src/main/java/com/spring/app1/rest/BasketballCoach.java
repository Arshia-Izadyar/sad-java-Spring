package com.spring.app1.rest;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class BasketballCoach implements Coach{
    @Override
    public String dailyWorkout() {
        return "200 three pointers";
    }

}
