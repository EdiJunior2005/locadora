package com.PA.locadora.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "role", length = 45)
    private String role;

    @Column(name = "hire_date")
    private LocalDate hireDate;
}
