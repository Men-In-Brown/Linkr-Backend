package com.nighthawk.spring_portfolio.mvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.nighthawk.spring_portfolio.mvc.linkr.Company;
import com.nighthawk.spring_portfolio.mvc.linkr.CompanyRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.CompanyService;
import com.nighthawk.spring_portfolio.mvc.linkr.Employee;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeController;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeRepository;
import com.nighthawk.spring_portfolio.mvc.linkr.EmployeeService;
import com.nighthawk.spring_portfolio.mvc.linkrAuthentication.LinkrPAT;
import com.nighthawk.spring_portfolio.mvc.linkrAuthentication.PatJpaRepository;
import com.nighthawk.spring_portfolio.mvc.note.Note;
import com.nighthawk.spring_portfolio.mvc.person.Person;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;

import java.util.List;

@Component
@Configuration // Scans Application for ModelInit Bean, this detects CommandLineRunner
public class ModelInit {  
    @Autowired PersonDetailsService personService;
    @Autowired PatJpaRepository patRepo;
    @Autowired EmployeeRepository employeeRepository;
    @Autowired CompanyRepository companyRepository;


    @Bean
    CommandLineRunner run() {  // The run() method will be executed after the application starts
        return args -> {

            Company[] clist = Company.companyInit();
            for (Company c : clist){
                if(c.getId() == null){
                    c.setId(companyRepository.getMaxId() + 1);
                }
                List<Company> found = companyRepository.findCompanyByNameIgnoreCase(c.getName());
                if (found.size() == 0){
                    companyRepository.save(c);
                }
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

            // Person database is populated with test data
            Person[] personArray = Person.init();
            for (Person person : personArray) {
                //findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase
                List<Person> personFound = personService.list(person.getName(), person.getEmail());  // lookup
                if (personFound.size() == 0) {
                    personService.save(person);  // save
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