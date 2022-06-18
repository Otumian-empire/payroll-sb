// Employee.java
package com.otumian.payroll;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Employee {
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    Employee() {
    }

    Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private boolean isEqualTo(Object obj) {
        Employee employee = (Employee) obj;

        boolean hasSameId = Objects.equals(this.id, employee.id);
        boolean hasSameName = Objects.equals(this.name, employee.name);
        boolean hasSameRole = Objects.equals(this.role, employee.role);

        return hasSameId && hasSameName && hasSameRole;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        return this.isEqualTo(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

    @Override
    public String toString() {
        /*
         * return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' +
         * ", role='" + this.role + '\'' + '}';
         */
        String template = "Employee{id=%d, name='%s', role='%s'";
        return String.format(template, id, name, role);

    }

}