package com.nighthawk.spring_portfolio.mvc.linkr2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<Company, Long> {
    Company findByNameCompany(String name);

    List<Company> findAllByNameIgnoreCase(String name);
    
    List<Company> findAllByOrderByNameAsc();

    Company findByEmail(String email);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Product") 
    public Long getMaxId();
}
