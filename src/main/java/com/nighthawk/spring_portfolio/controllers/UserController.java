// package com.nighthawk.spring_portfolio.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import com.nighthawk.spring_portfolio.mvc.linkr.LinkrUser;
// import com.nighthawk.spring_portfolio.mvc.linkr.UserLinkrService;

// import java.util.Optional;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {
//     @Autowired
//     private UserLinkrService userService;

//     @PostMapping
//     public LinkrUser saveUser(@RequestBody LinkrUser user) {
//         return userService.saveUser(user);
//     }

//     @GetMapping("/{userId}")
//     public Optional<LinkrUser> getUserById(@PathVariable Long userId) {
//         return userService.getUserById(userId);
//     }

//     @DeleteMapping("/{userId}")
//     public void deleteUser(@PathVariable Long userId) {
//         userService.deleteUser(userId);
//     }
// }
