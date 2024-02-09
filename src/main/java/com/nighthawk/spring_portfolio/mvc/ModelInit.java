package com.nighthawk.spring_portfolio.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.nighthawk.spring_portfolio.mvc.LinkrJWT.LinkrPAT;
import com.nighthawk.spring_portfolio.mvc.LinkrJWT.PatJpaRepository;
import com.nighthawk.spring_portfolio.mvc.jokes.Jokes;
import com.nighthawk.spring_portfolio.mvc.jokes.JokesJpaRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.Company;
import com.nighthawk.spring_portfolio.mvc.linkr.CompanyRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.CompanyService;
import com.nighthawk.spring_portfolio.mvc.linkr.Employee;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeController;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeService;

import java.util.List;

@Component
@Configuration // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class ModelInit {  
    @Autowired JokesJpaRepository jokesRepo;
    @Autowired NoteJpaRepository noteRepo;
    @Autowired PersonDetailsService personService;
    @Autowired PatJpaRepository patRepo;
    @Autowired EmployeeRepository employeeRepository;
    @Autowired CompanyRepository companyRepository;

    @Bean
    CommandLineRunner run() {  // The run() method will be executed after the application starts
        return args -> {

            // Joke database is populated with starting jokes
            String[] jokesArray = Jokes.init();
            for (String joke : jokesArray) {
                List<Jokes> jokeFound = jokesRepo.findByJokeIgnoreCase(joke);  // JPA lookup
                if (jokeFound.size() == 0)
                    jokesRepo.save(new Jokes(null, joke, 0, 0)); //JPA save
            }

            Company[] clist = Company.companyInit();
            for (Company c : clist){
                if(c.getId() == null){
                    c.setId(companyRepository.getMaxId() + 1);
                }

                companyRepository.save(c);
            }

            Employee[] elist = Employee.EmployeeInit();
            for (Employee e : elist){
                if(e.getId() == null){
                    e.setId(employeeRepository.getMaxId() + 1);
                }
                List<Employee> foundEmails = employeeRepository.findAllByEmail(e.getEmail());
                if(foundEmails.size() == 0){
                    employeeRepository.save(e);
                }
            }
        

            LinkrPAT[] list = LinkrPAT.init();
            for(LinkrPAT l : list){
                List<LinkrPAT> found = patRepo.findAllByUser(l.getUser());
                if(found.size() == 0){
                    patRepo.save(l);
                }
            }

        };
    }
}