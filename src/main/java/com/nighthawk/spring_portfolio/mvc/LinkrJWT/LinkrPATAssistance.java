package com.nighthawk.spring_portfolio.mvc.LinkrJWT;

import org.junit.runners.Parameterized.BeforeParam;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class LinkrPATAssistance {
    @Bean
    public PATTask execute(){
        return new PATTask(); 
    }
}
