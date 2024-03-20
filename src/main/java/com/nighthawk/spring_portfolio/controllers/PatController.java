package com.nighthawk.spring_portfolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nighthawk.spring_portfolio.mvc.linkr.User;
import com.nighthawk.spring_portfolio.mvc.linkr.UserRepository;
import com.nighthawk.spring_portfolio.mvc.linkrAuthentication.LinkrPAT;
import com.nighthawk.spring_portfolio.mvc.linkrAuthentication.PatJpaRepository;

public class PatController {
    @Autowired
    PatJpaRepository PATRepository;

    @GetMapping("/api/pats")
    public String UsersAPI(Model model){
        List<LinkrPAT> allUsers = PATRepository.findAll();
        model.addAttribute("PATS", allUsers);
        
        return "linkrPATs";
    }

    @GetMapping("/api/pats")
    public LinkrPAT getAPIByUser(String name){
        List<LinkrPAT> allUsers = PATRepository.findAll();
        for (LinkrPAT l : allUsers){
            if(l.getUser().equals(name)){
                return l;
            }
        }
        return new LinkrPAT();
    }
}
