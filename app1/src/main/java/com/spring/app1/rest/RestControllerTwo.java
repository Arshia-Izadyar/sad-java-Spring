package com.spring.app1.rest;

import com.spring.app1.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerTwo {

    // setter
    private Coach myCoach;
    private Coach myCoach2;

    @Autowired
    public void setCoach(@Qualifier("baseBallCoach") Coach c, @Qualifier("baseBallCoach") Coach c2){
        myCoach = c;
        myCoach2 = c2;

    }

    @GetMapping("/baseball")
    public String baseball(){
        return myCoach.dailyWorkout()+" baseball"+ myCoach2.equals(myCoach);
    }
}
