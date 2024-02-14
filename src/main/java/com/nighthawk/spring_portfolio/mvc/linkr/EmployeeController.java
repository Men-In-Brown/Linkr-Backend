package com.nighthawk.spring_portfolio.mvc.linkr;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nighthawk.spring_portfolio.mvc.person.Person;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Using lombok to automatically generate a logger
@Slf4j
@RestController
@RequestMapping("/api/employees") // Base URL for all endpoints in this controller
public class EmployeeController {

    private final EmployeeService employeeService; // Service for employee-related operations
    private final ModelMapper modelMapper; // For entity-to-DTO mapping
    private final PersonDetailsService personDetailsService; // Service for managing person details

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper, PersonDetailsService personDetailsService) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
        this.personDetailsService = personDetailsService;
    }

    // Endpoint to get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        // Retrieving all employees and mapping them to DTOs
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDTOs, HttpStatus.OK); // Returning DTO list with OK status
    }

    // Endpoint to get an employee by their ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        log.info("Attempting to retrieve employee with ID: {}", employeeId); // Logging the attempt
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId); // Retrieving employee by ID
        if (employee.isPresent()) { // If employee is found
            log.info("Found employee with ID: {}", employeeId); // Logging successful retrieval
            return ResponseEntity.ok().body(employee.get()); // Returning employee with OK status
        } else { // If employee is not found
            log.warn("Employee with ID {} not found", employeeId); // Logging warning for not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Returning NOT_FOUND status
        }
    }

    // Endpoint to add a new employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        log.info("Attempting to add employee: {}", employee); // Logging the attempt
        Employee addedEmployee = employeeService.createEmployee(employee); // Creating the employee
        log.info("Employee added successfully: {}", addedEmployee); // Logging successful addition
        
        // Creating a Person object and saving person details
        Person p6 = new Person();
        p6.setName("No Name");
        p6.setEmail(employee.getEmail());
        p6.setPassword(employee.getPassword());
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("05-15-2007");
            p6.setDob(d);
        } catch (Exception e) {
        }
        personDetailsService.save(p6); // Saving person details
        
        System.out.println("Hello"); // Printing a message
        
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED); // Returning the added employee with CREATED status
    }

    // Endpoint to delete an employee by their ID
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        log.info("Attempting to delete employee with ID: {}", employeeId); // Logging the attempt
        employeeService.deleteEmployee(employeeId); // Deleting the employee
        log.info("Employee with ID {} deleted successfully", employeeId); // Logging successful deletion
        return ResponseEntity.noContent().build(); // Returning NO_CONTENT status
    }
}