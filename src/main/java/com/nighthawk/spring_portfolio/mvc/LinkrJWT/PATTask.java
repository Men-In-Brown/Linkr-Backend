package com.nighthawk.spring_portfolio.mvc.LinkrJWT;

import org.springframework.scheduling.annotation.Scheduled;

public class PATTask {
    
    @Scheduled(fixedRate = 1000)
    public void TestTask(){
        System.out.println("hello world");
    }
}
