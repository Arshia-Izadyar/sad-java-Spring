package com.spring.app1.common;

public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("swim coach arived");
    }
    @Override
    public String dailyWorkout() {
        return "<h1>swim swim swag swag</h1>";
    }
}
