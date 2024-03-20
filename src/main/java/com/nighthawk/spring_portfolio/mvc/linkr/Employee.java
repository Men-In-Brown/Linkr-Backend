package com.nighthawk.spring_portfolio.mvc.linkr;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private String email;
    private String password;
    private int followers;

    // change to hashmap
    private int ideas;
    private int joined; 

    private int investments; 


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


    public Employee(String name, String position, String email, String password){
        this.name = name;
        this.position = position;
        this.email = email;
        this.password = password;
        this.ideas = 0;
        this.joined = 0;
        this.investments = 0;
    }

    public static Employee[] EmployeeInit(){
        Employee e1 = new Employee("Tanay", "CEO", "tpatel@gmail.com", "123Tanay!");
        Employee e2 = new Employee("Varaprasad", "CTO", "vnibhanupudi@gmail.com", "123Vlu!");
        Employee e3 = new Employee("Paaras", "CFO", "ppurohit@gmail.com", "123Paras!");
        Employee e4 = new Employee("Tobias", "Employee", "toby@gmail.com", "123Toby");
        Employee e5 = new Employee("Hubert", "Employee", "hop@gmail.com", "123hop");
        Employee[] elist =  {e1, e2, e3};
        return elist;
    }
}