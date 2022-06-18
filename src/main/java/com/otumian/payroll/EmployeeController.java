package com.otumian.payroll;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    // inject the repository
    private final EmployeeRepository repository;

    // logger
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // get all employees
    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    // create an employee
    @PostMapping("/employees")
    Employee create(@RequestBody Employee employee) {
        logger.info("PostMapping: " + employee.toString());
        return repository.save(employee);
    }

    // get Employee by ID
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        logger.info("GetMapping: id-> " + id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // update employee by id
    @PutMapping("/employees/{id}")
    Employee put(@RequestBody Employee employee, @PathVariable Long id) {
        logger.info("PutMapping: id -> " + id + "\n " + employee.toString());
        return repository.findById(id).map(thisEmployee -> {
            thisEmployee.setName(employee.getName());
            thisEmployee.setRole(employee.getRole());

            return repository.save(thisEmployee);
        }).orElseGet(() -> {
            employee.setId(id);

            return repository.save(employee);
        });
    }

    // delete employee by id
    @DeleteMapping("/employees/{id}")
    void delete(@PathVariable Long id) {
        logger.info("DeleteMapping: id -> " + id);
        repository.deleteById(id);
    }

}
