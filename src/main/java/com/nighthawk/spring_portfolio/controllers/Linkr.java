package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Linkr {
    @GetMapping("/linkr")
    // @RequestParam handles variables binding to frontend, defaults, etc
    public String linkrdisplay() {
        
        
        return "linkradmin";
    }

    




}
