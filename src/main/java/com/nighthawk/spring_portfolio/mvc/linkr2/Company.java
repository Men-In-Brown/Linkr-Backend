package com.nighthawk.spring_portfolio.mvc.linkr2;

import java.util.Date;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@Convert(attributeName ="person", converter = JsonType.class)
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id // ID, is long
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
 
    @Column(unique = true) // email, needs to be unique
    private String email;

    private String name; // Name of company
    private boolean isActive; // Is active, an autoset thing we can change

    public Company(String name, String email) {
        this.name = name;
        this.email = email;
        this.isActive = true;
    }

    public static Company[] init(){
        Company[] companyList = {
            new Company("Hello world", "bob@gmail.com"),
            new Company("Number 2", "example@gmail.com"),
            new Company("w", "user@hotmail.com")
        };

        return companyList;
    }


}
