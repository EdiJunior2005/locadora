package com.PA.locadora.DTOs;

import com.PA.locadora.models.Filme;

public class FilmeDTO {
    private Long id;
    private String titulo;
    private String genero;
    private int anoLancamento;
    private boolean disponivel;

    public FilmeDTO(Filme filme) {
        this.id = filme.getId();
        this.titulo = filme.getTitulo();
        this.genero = filme.getGenero();
        this.anoLancamento = filme.getAnoLancamento();
        this.disponivel = filme.isDisponivel();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
} 
