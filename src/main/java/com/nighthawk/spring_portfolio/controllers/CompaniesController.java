package com.nighthawk.spring_portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.linkr.Company;
import com.nighthawk.spring_portfolio.mvc.linkr.CompanyRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.Employee;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeRepository;

import org.springframework.ui.Model;

import java.util.List;


@Controller
public class CompaniesController {
    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/api/controllers")
    public String UsersAPI(Model model){
        List<Company> allEmployees = companyRepository.findAll();
        System.out.println(allEmployees.size());
        model.addAttribute("employees", allEmployees);
        
        return "linkrcompanies";
    }
}
