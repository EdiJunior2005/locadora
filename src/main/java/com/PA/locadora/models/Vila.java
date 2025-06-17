package com.PA.locadora.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_vila")
public class Vila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "numero_habitantes", nullable = false)
    private int numeroHabitantes;

    @OneToMany(mappedBy = "vila", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ninja> ninjas;
}
