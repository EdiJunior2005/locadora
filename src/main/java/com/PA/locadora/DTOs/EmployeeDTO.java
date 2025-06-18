package com.PA.locadora.DTOs;

import com.PA.locadora.models.Employee;

import java.time.LocalDate;

public record EmployeeDTO(
        Long id,
        String name,
        String role,
        LocalDate hireDate
) {
    public EmployeeDTO(Employee employee) {
        this(
            employee.getId(),
            employee.getName(),
            employee.getRole(),
            employee.getHireDate()
        );
    }
}
