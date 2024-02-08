package com.nighthawk.spring_portfolio.mvc.LinkrJWT;

import java.util.Date;

import groovy.transform.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.NoArgsConstructor;

@Entity
@Table
public class LinkrPAT {

    @Id
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation; 
    
    private String PAT;

    //private Employee attachedUser;

    public LinkrPAT(){
        this.creation = new Date();
        this.PAT = "";
    }

    public void setPAT(String _PAT){
        this.PAT = _PAT;
    }

    public String getPAT() {
        return this.PAT;
    }
    
    
}
