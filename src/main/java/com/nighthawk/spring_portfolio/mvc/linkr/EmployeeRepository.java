package com.nighthawk.spring_portfolio.mvc.linkr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    List<Employee> findAllById(Long id);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Employee")
     Long getMaxId();

    Employee findByEmail(String email);

    List<Employee> findAllByEmail(String email);

}