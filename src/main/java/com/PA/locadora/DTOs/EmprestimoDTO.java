package com.PA.locadora.DTOs;

import com.PA.locadora.models.Emprestimo;

import java.time.LocalDate;

public class EmprestimoDTO {
    private Long id;
    private String nomeCliente;
    private String tituloFilme;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public EmprestimoDTO(Emprestimo e) {
        this.id = e.getId();
        this.nomeCliente = e.getCliente().getNome();
        this.tituloFilme = e.getFilme().getTitulo();
        this.dataEmprestimo = e.getDataEmprestimo();
        this.dataDevolucao = e.getDataDevolucao();
        this.devolvido = e.isDevolvido();
    }

    public Long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }
}
