package com.PA.locadora.DTOs;

import com.PA.locadora.models.Rental;

import java.time.LocalDateTime;

public record RentalDTO(
        Long id,
        LocalDateTime rentalDate,
        LocalDateTime returnDate,
        Long customerId,
        Long dvdId,
        Long employeeId
) {
    public RentalDTO(Rental rental) {
        this(
            rental.getId(),
            rental.getRentalDate(),
            rental.getReturnDate(),
            rental.getCustomer() != null ? rental.getCustomer().getId() : null,
            rental.getDvd() != null ? rental.getDvd().getId() : null,
            rental.getEmployee() != null ? rental.getEmployee().getId() : null
        );
    }
}
