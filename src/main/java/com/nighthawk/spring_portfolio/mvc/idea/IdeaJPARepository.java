package com.nighthawk.spring_portfolio.mvc.idea;

// IdeaJPARepository.java

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaJPARepository extends JpaRepository<Idea, Long> {
    // Custom queries can be added here if needed
}