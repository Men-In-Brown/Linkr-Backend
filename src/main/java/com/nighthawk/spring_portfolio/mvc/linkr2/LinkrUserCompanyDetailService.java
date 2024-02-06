package com.nighthawk.spring_portfolio.mvc.linkr2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LinkrUserCompanyDetailService {

    @Autowired
    static LinkrUserJpaRepository repository;


    public static LinkrUser saveCompany(LinkrUser user) {
        if (user.getId() == null) {
            // If the company doesn't have an id, generate one, needs to be added to
            user.setId(generateNextId());
        }
        repository.save(user);
        return user;
    }

    private static Long generateNextId() {
        // generate the next id, again, it should be changed to be more secure
        return repository.getMaxId() + 1; 
    }
}
