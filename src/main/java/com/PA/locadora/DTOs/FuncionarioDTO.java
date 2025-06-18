package com.PA.locadora.DTOs;

import com.PA.locadora.models.Funcionario;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cargo;
    private String email;

    public FuncionarioDTO(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.cargo = f.getCargo();
        this.email = f.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getEmail() {
        return email;
    }
}
