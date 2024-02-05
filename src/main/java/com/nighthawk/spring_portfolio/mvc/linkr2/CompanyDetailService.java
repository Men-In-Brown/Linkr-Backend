package com.nighthawk.spring_portfolio.mvc.linkr2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyDetailService {

    @Autowired
    static CompanyJpaRepository repository;

    

    public static Company saveCompany(Company company) {
        if (company.getId() == null) {
            // If the company doesn't have an id, generate one, needs to be added to
            company.setId(generateNextId());
        }
        repository.save(company);
        return company;
    }

    private static Long generateNextId() {
        // generate the next id, again, it should be changed to be more secure
        return repository.getMaxId() + 1; 
    }
}
