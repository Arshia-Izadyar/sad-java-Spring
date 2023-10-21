package com.spring.app1.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // if there is no Qualified we use this or override it with Qualified
@Lazy // lazy load
public class BasketballCoach implements Coach {

    public BasketballCoach(){
        System.out.println("Basketball");
    }

    @Override
    public String dailyWorkout() {
        return "200 three pointers";
    }

}
