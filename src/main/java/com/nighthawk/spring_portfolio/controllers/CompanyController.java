// package com.nighthawk.spring_portfolio.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.nighthawk.spring_portfolio.mvc.linkr.Company;
// import com.nighthawk.spring_portfolio.mvc.linkr.CompanyService;

// import java.util.List;

// @RestController
// @RequestMapping("/api/companies")
// public class CompanyController {
//     @Autowired
//     private CompanyService companyService;

//     @GetMapping
//     public List<Company> getAllCompanies() {
//         return companyService.getAllCompanies();
//     }

//     @GetMapping("/{companyId}")
//     public Company getCompanyById(@PathVariable Long companyId) {
//         return companyService.getCompanyById(companyId);
//     }

//     @PostMapping
//     public Company saveCompany(@RequestBody Company company) {
//         return CompanyService.saveCompany(company);
//     }

//     @PutMapping("/{companyId}")
//     public Company updateCompany(@PathVariable Long companyId, @RequestBody Company updatedCompany) {
//         Company existingCompany = companyService.getCompanyById(companyId);
//         if (existingCompany != null) {
//             // Update fields
//             existingCompany.setName(updatedCompany.getName());
//             existingCompany.setMission(updatedCompany.getMission());
//             existingCompany.setLocation(updatedCompany.getLocation());
//             existingCompany.setIndustry(updatedCompany.getIndustry());
//             existingCompany.setSize(updatedCompany.getSize());
//             existingCompany.setDescription(updatedCompany.getDescription());
//             existingCompany.setWebsite(updatedCompany.getWebsite());
//             existingCompany.setFoundedYear(updatedCompany.getFoundedYear());
//             existingCompany.setCeo(updatedCompany.getCeo());

//             return CompanyService.saveCompany(existingCompany);
//         }
//         return null;
//     }

//     @DeleteMapping("/{companyId}")
//     public void deleteCompany(@PathVariable Long companyId) {
//         companyService.deleteCompany(companyId);
//     }
// }