package com.nighthawk.spring_portfolio.mvc.linkr2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkrUserJpaRepository extends JpaRepository<LinkrUser, Long> {

    // Updated method to fix the issue
    Company findByName(String name);

    List<Company> findAllByNameIgnoreCase(String name);

    List<Company> findAllByOrderByNameAsc();

    Company findByEmail(String email);

    @Query(value = "SELECT coalesce(max(id), 0) FROM Company")
    Long getMaxId();
}
