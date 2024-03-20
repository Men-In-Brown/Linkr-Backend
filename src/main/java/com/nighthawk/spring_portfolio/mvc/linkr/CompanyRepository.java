package com.nighthawk.spring_portfolio.mvc.linkr;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Repository interface for performing CRUD operations on the Company entity,
    // including custom queries for specific data retrieval needs.
    List<Company> findAll();

    List<Company> findAllById(long i);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Company")
     Long getMaxId();

    List<Company> findCompanyByNameIgnoreCase(String name);
}