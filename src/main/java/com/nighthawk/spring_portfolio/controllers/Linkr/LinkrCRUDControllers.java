package com.nighthawk.spring_portfolio.controllers.Linkr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ch.qos.logback.core.model.Model;

@Controller
public class LinkrCRUDControllers {

    /*
     * @Autowired
     * CompanyRepository repository;
     */

    @GetMapping("/linkr/{companyID}")
    public String linkrCompanyDisplay (@PathVariable String companyID, Model model){
        // Company companyInfo = getCompanyByID
        
        //TODO: implement adding stuff to the model in order ot get this to acutally work

        return "kill yourself";
    }

}
