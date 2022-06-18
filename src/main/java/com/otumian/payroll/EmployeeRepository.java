// EmployeeRepository.java
package com.otumian.payroll;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository: this is allow CRUD
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}