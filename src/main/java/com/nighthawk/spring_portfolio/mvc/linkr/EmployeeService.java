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

    // Method to retrieve all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Method to retrieve an employee by their ID
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    // Method to create a new employee
    public Employee createEmployee(Employee employee) {
        // If the employee ID is not provided, generate a new ID
        if(employee.getId() == null){
            employee.setId(generateNextId());
        }
        return employeeRepository.save(employee); // Save the employee and return it
    }

    // Method to delete an employee by their ID
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    // Method to load user by username (email) for authentication purposes
    public Employee loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee person = employeeRepository.findByEmail(email); // Retrieve user by email from the database
        if(person==null) { // If user is not found
            throw new UsernameNotFoundException("User not found with username: " + email); // Throw exception
        }
        // make sure it recognizes User and Authorities
        return new Employee(null, null, person.getEmail(), person.getPassword());
    }

    // Method to generate the next ID for a new employee
    private Long generateNextId() {
        // Generate the next ID by retrieving the maximum ID and incrementing it
        return employeeRepository.getMaxId() + 1; 
    }
}