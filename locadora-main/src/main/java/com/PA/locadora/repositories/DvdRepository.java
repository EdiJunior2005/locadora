package com.PA.locadora.repositories;

import com.PA.locadora.models.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
}
