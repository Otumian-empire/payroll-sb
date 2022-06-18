// LoadDatabase.java
package com.otumian.payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * LoadDatabase
 */
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading: " + repository.save(new Employee("Kevin Amevor", "Android Engineer")));

            log.info("Preloading: " + repository.save(new Employee("Yussif Amevor", "Sale Accountant")));
        };
    }
}