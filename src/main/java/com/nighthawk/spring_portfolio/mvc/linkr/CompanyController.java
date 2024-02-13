package com.nighthawk.spring_portfolio.mvc.linkr;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyService companyService;
    private final ModelMapper modelMapper;

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        List<CompanyDTO> companyDTOs = companies.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        log.info("Attempting to retrieve company with ID: {}", companyId);
        Optional<Company> company = companyService.getCompanyById(companyId);
        if (company.isPresent()) {
            log.info("Found company with ID: {}", companyId);
            return ResponseEntity.ok().body(company.get());
        } else {
            log.warn("Company with ID {} not found", companyId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        log.info("Attempting to add company: {}", company);
        Company addedCompany = companyService.createCompany(company);
        log.info("Company added successfully: {}", addedCompany);
        return new ResponseEntity<>(addedCompany, HttpStatus.CREATED);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        System.out.println("Attempting to delete company with ID: " + companyId);
        companyService.deleteCompany(companyId);
        System.out.println("Company with ID {} deleted successfully" + companyId);
        return ResponseEntity.noContent().build();
    }
}