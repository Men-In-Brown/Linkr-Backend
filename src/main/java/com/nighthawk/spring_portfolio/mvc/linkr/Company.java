package com.nighthawk.spring_portfolio.mvc.linkr;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "company")
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // user
    private String mission; // user
    private String location; // user
    private String industry; // user
    private int size; // automated
    private String description; // set to null, can be replaced
    private String website; // set to null, can be replaced
    private int foundedYear; // automated
    private String ceo; // automated (employee creating company)
    // private int investments;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();


    public Company(String name, String mission, String location, String industry, String ceo){
        // Users Set
        this.name = name;
        this.mission = mission;
        this.location = location;
        this.industry = industry;

        // Automated Set
        this.foundedYear = Year.now().getValue();
        this.ceo = ceo;
        this.size = 0;
        
        // null Set
        this.description = null;
        this.website = null;
    }

    public static Company[] companyInit(){
        Company c1 = new Company("Name 1", "To Name", "California", "Tech", "None");
        Company c2 = new Company("Name 2", "To not name", "India", "Hosptality", "Tanay");
        Company c3 = new Company("Name 3", "That is the question", "Shanghai", "Tax Fraud", "Paaras");
        Company[] clist = {c1, c2, c3};
        return clist;
    }
}