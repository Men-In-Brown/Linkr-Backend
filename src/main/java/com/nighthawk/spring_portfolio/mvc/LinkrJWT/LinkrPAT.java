package com.nighthawk.spring_portfolio.mvc.LinkrJWT;

import java.util.Date;

public class LinkrPAT {
    private Date creation; 
    

    private Employee attachedUser;

    public LinkrPAT(Employee attachedUser){
        this.creation = new Date();
        this.attachedUser = attachedUser;
    }

    
    
}
