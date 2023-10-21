package com.spring.app1.config;

import com.spring.app1.common.Coach;
import com.spring.app1.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("swimCoach") // bean id
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
