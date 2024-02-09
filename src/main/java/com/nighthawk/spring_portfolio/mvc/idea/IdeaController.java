package com.nighthawk.spring_portfolio.mvc.idea;

// IdeaController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ideas")
public class IdeaController {

    @Autowired
    private IdeaJPARepository ideaRepository;

    // Define your API endpoints here
    
    // Example endpoint to get all ideas
    @GetMapping
    public ResponseEntity<?> getAllIdeas() {
        // Implement your logic to retrieve ideas
        // Return ResponseEntity with the list of ideas
        return ResponseEntity.ok(ideaRepository.findAll());
    }

    // Other endpoints for creating, updating, deleting ideas, etc.
}