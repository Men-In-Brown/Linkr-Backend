package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<LinkrUser, Long> {
    // add custom query methods here to filter and stuff
    
}