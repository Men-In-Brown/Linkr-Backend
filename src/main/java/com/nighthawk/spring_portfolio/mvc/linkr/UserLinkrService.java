package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserLinkrService {
    private final UserJpaRepository userRepository;

    public UserLinkrService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LinkrUser saveUser(LinkrUser user) {
        return userRepository.save(user);
    }

    public Optional<LinkrUser> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}