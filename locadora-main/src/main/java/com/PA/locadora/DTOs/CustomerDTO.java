package com.PA.locadora.DTOs;

import com.PA.locadora.models.Customer;

public record CustomerDTO(
        Long id,
        String name,
        String phone,
        String address
) {
    public CustomerDTO(Customer customer) {
        this(
            customer.getId(),
            customer.getName(),
            customer.getPhone(),
            customer.getAddress()
        );
    }
}
