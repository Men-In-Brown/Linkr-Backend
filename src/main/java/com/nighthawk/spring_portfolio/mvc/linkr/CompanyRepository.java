package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}