package com.PA.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PA.locadora.models.Missao;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Long> {

}
