package com.nighthawk.spring_portfolio.mvc.linkr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Employee createEmployee(Employee employee) {
        if(employee.getId() == null){
            employee.setId(generateNextId());
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee person = employeeRepository.findByEmail(email); // setting variable user equal to the method finding the username in the database
        if(person==null) {
			throw new UsernameNotFoundException("User not found with username: " + email);
        }
        // train spring security to User and Authorities
        return new Employee(null, null, person.getEmail(), person.getPassword());
    }

    private Long generateNextId() {
        // generate the next id, again, it should be changed to be more secure
        return employeeRepository.getMaxId() + 1; 
    }
}