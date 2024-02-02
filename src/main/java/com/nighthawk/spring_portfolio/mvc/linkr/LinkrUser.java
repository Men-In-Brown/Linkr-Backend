package com.nighthawk.spring_portfolio.mvc.linkr;

import lombok.Data;
import java.util.HashMap;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "userboothang")
public class LinkrUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String position;
    private List<Company> companies; 
    private HashMap paymentInfo;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
