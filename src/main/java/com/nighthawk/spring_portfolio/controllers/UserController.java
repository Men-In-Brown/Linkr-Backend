package com.nighthawk.spring_portfolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.nighthawk.spring_portfolio.mvc.linkr.User;
import com.nighthawk.spring_portfolio.mvc.linkr.UserRepository;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository employeeRepository;

    @GetMapping("/api/users")
    public String UsersAPI(Model model){
        List<User> allUser = employeeRepository.findAll();
        model.addAttribute("students", allUser);
        
        return "linkradmin";
    }
}
