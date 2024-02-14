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

// Using lombok to automatically generate a logger
@Slf4j
@RestController
@RequestMapping("/api/companies") // Base URL for all endpoints in this controller
@CrossOrigin(origins = "*") // Allowing cross-origin requests from any origin
public class CompanyController {

    private final CompanyService companyService; // Service to handle business logic
    private final ModelMapper modelMapper; // For entity-to-DTO mapping

    @Autowired
    public CompanyController(CompanyService companyService, ModelMapper modelMapper) {
        this.companyService = companyService;
        this.modelMapper = modelMapper;
    }

    // Endpoint to get all companies
    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies(); // Retrieve companies from the service
        List<CompanyDTO> companyDTOs = companies.stream()
                .map(company -> modelMapper.map(company, CompanyDTO.class)) // Map entities to DTOs
                .collect(Collectors.toList()); // Collect DTOs into a list
        return new ResponseEntity<>(companyDTOs, HttpStatus.OK); // Return DTO list with OK status
    }

    // Endpoint to get a company by its ID
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        log.info("Attempting to retrieve company with ID: {}", companyId); // Log the attempt
        Optional<Company> company = companyService.getCompanyById(companyId); // Retrieve the company by ID
        if (company.isPresent()) { // If company is found
            log.info("Found company with ID: {}", companyId); // Log successful retrieval
            return ResponseEntity.ok().body(company.get()); // Return company with OK status
        } else { // If company is not found
            log.warn("Company with ID {} not found", companyId); // Log warning for not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return NOT_FOUND status
        }
    }

    // Endpoint to add a new company
    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        log.info("Attempting to add company: {}", company); // Log the attempt
        Company addedCompany = companyService.createCompany(company); // Create the company
        log.info("Company added successfully: {}", addedCompany); // Log successful addition
        return new ResponseEntity<>(addedCompany, HttpStatus.CREATED); // Return the added company with CREATED status
    }

    // Endpoint to delete a company by its ID
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long companyId) {
        System.out.println("Attempting to delete company with ID: " + companyId); // Log the attempt
        companyService.deleteCompany(companyId); // Delete the company
        System.out.println("Company with ID {} deleted successfully" + companyId); // Log successful deletion
        return ResponseEntity.noContent().build(); // Return NO_CONTENT status
    }
}