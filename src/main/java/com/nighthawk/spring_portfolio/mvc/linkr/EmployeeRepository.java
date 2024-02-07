package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // add stuff for searching employees
}