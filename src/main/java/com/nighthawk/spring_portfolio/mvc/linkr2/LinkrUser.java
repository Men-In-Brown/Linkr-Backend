package com.nighthawk.spring_portfolio.mvc.linkr2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.commonmark.node.Link;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.LinkedMultiValueMap;

import com.vladmihalcea.hibernate.type.json.JsonType;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Data;

@Data
@Entity
@Table
@Convert(attributeName ="LinkrUser", converter = JsonType.class)
@NoArgsConstructor
@AllArgsConstructor
public class LinkrUser {

    @Id // ID, is long
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @NonNull, etc placed in params of constructor: "@NonNull @Size(min = 2, max = 30, message = "Name (2 to 30 chars)") String name"
    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;
    
     // automatic unique identifier for Person record


    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Size(min=5)
    @Column(unique=true)
    @Email
    private String email;

    @NotEmpty
    private String password;
    

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public LinkrUser(String email, String password, String name, Date dob) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }

    public static LinkrUser[] initLinkrUsers(){
        LinkrUser p1 = new LinkrUser();
        try {
            p1.setDob(new SimpleDateFormat("MM-dd-yyyy").parse("01-01-1840"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p1.setName("Paaras");
        p1.setEmail("null@gmail.com");
        p1.setPassword("No!!");

        LinkrUser p2 = new LinkrUser();
        try {
            p2.setDob(new SimpleDateFormat("MM-dd-yyyy").parse("01-02-1244"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p2.setName("Varlu");
        p2.setEmail("sfs@gmail.com");
        p2.setPassword("No!12421!");

        LinkrUser p3 = new LinkrUser();
        try {
            p3.setDob(new SimpleDateFormat("MM-dd-yyyy").parse("01-03-1525"));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p3.setName("Tany");
        p3.setEmail("df124s@gmail.com");
        p3.setPassword("No!4212421!");

        LinkrUser[] linkrList = {p1, p2, p3};
        
        return linkrList;
    }

}
