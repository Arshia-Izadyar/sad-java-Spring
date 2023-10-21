package com.spring.app1.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // default singleton
public class BaseBallCoach implements Coach {
    @PostConstruct
    public void init(){
        System.out.println("Base ball init ");
    }

    @PreDestroy
    public void tearDown(){
        System.out.println("destroying the obj");
    }

    public BaseBallCoach(){
        System.out.println("BaseBall");
    }

    @Override
    public String dailyWorkout() {
        return "baseball is cool";
    }
}
