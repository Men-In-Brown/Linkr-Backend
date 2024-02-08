package com.nighthawk.spring_portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.linkr.CompanyRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.Employee;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeRepository;

import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller

public class UserController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/api/users")
    public String UsersAPI(Model model){
        List<Employee> allEmployees = employeeRepository.findAll();
        model.addAttribute("employees", allEmployees);
        
        return "linkradmin";
    }
}
