package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    private final static List<Company> companyList = new ArrayList<>();

    public List<Company> getAllCompanies() {
        return companyList;
    }

    public Company getCompanyById(Long companyId) {
        return companyList.stream()
                .filter(company -> company.getId().equals(companyId))
                .findFirst()
                .orElse(null);
    }

    public static Company saveCompany(Company company) {
        if (company.getId() == null) {
            // If the company doesn't have an id, generate one, needs to be added to
            company.setId(generateNextId());
        }
        companyList.add(company);
        return company;
    }

    public void deleteCompany(Long companyId) {
        companyList.removeIf(company -> company.getId().equals(companyId));
    }

    private static Long generateNextId() {
        // generate the next id, again, it should be changed to be more secure
        return companyList.isEmpty() ? 1 : companyList.get(companyList.size() - 1).getId() + 1;
    }
}