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

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long companyId) {
        return companyRepository.findById(companyId);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
