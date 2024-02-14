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

@Slf4j
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;
    private final PersonDetailsService personDetailsService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper modelMapper, PersonDetailsService personDetailsService) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
        this.personDetailsService = personDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        log.info("Attempting to retrieve employee with ID: {}", employeeId);
        Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
        if (employee.isPresent()) {
            log.info("Found employee with ID: {}", employeeId);
            return ResponseEntity.ok().body(employee.get());
        } else {
            log.warn("Employee with ID {} not found", employeeId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        
        log.info("Attempting to add employee: {}", employee);
        Employee addedEmployee = employeeService.createEmployee(employee);
        log.info("Employee added successfully: {}", addedEmployee);
        Person p6 = new Person();
        p6.setName("No Name");
        p6.setEmail(employee.getEmail());
        p6.setPassword(employee.getPassword());
        try {
            Date d = new SimpleDateFormat("MM-dd-yyyy").parse("05-15-2007");
            p6.setDob(d);
        } catch (Exception e) {
        }

        personDetailsService.save(p6);
        
        System.out.println("Hello");
        
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        log.info("Attempting to delete employee with ID: {}", employeeId);
        employeeService.deleteEmployee(employeeId);
        log.info("Employee with ID {} deleted successfully", employeeId);
        return ResponseEntity.noContent().build();
    }
}