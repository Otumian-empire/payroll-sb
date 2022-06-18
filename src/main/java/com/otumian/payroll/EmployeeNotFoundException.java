package com.otumian.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeNotFoundException.class);

    EmployeeNotFoundException(Long id) {
        super("Could not find employee with id: " + id);
        logger.error("An error occurred");
    }
}
