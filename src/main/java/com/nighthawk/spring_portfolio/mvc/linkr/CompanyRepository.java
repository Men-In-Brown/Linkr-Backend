package com.nighthawk.spring_portfolio.mvc.linkr;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    List<Company> findAllById(Long id);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Company")
     Long getMaxId();

}