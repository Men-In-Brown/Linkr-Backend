package com.nighthawk.spring_portfolio.mvc.LinkrJWT;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PATTask {
    
    @Scheduled(fixedRate = 1000)
    public void TestTask(){
        System.out.println("hello world");
    }
}
