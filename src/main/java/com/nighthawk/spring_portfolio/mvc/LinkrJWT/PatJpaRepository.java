package com.nighthawk.spring_portfolio.mvc.LinkrJWT;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatJpaRepository extends JpaRepository<LinkrPAT, Long> {


    List<LinkrPAT> findAll();

}