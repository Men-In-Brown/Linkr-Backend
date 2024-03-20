package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Method to retrieve all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }    

    // Method to retrieve a company by its ID
    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    // Method to create a new company
    public Company createCompany(Company company) {
        // If the company ID is not provided, generate a new ID
        if(company.getId() == null){
            company.setId(generateNextId());
        }
        return companyRepository.save(company); // Save the company and return it
    }

    // Method to delete a company by its ID
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }

    // Method to generate the next ID for a new company
    private Long generateNextId() {
        // Generate the next ID by retrieving the maximum ID and incrementing it
        // Note: This approach might not be secure in a concurrent environment and should be improved
        return companyRepository.getMaxId() + 1; 
    }
}