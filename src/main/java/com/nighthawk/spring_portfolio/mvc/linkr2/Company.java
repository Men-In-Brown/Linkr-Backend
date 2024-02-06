package com.nighthawk.spring_portfolio.mvc.linkr2;

import java.time.Year;
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
@Convert(attributeName ="company", converter = JsonType.class)
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
    private String bio;
    private String location;
    private String[] tags;
    private int size;
    private String description;
    private String website;
    private int foundedYear;
    private String ceo;
    private String additionalInfo;

    public Company(String name, String email, String description, String ceo, String[] tags) {
        // Provided data
        this.name = name;
        this.email = email;
        this.bio = description;
        this.ceo = ceo;
        this.tags = tags;

        // Presents
        this.foundedYear = Year.now().getValue();
        this.email = null;
        this.isActive = true;
        this.size = 0;
        this.additionalInfo = null;
    }


    public String getName(){return this.name;}

    public static Company[] init(){
        String[] t1 = {"CS","Tech"};
        String[] t2 = {"Hospitality"};
        String[] t3 = {"Charity","Nonprofit"};
        Company[] companyList = {
            new Company("Hello world", "bob@gmail.com", "no", "Me", t1),
            new Company("Number 2", "example@gmail.com", "q2e", "Paaras", t2),
            new Company("w", "user@hotmail.com", "dy8u3ij", "Tanay", t3)
        };

        return companyList;
    }


}
