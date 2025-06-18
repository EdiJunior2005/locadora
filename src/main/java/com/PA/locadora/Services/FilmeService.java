package com.PA.locadora.Services;

import com.PA.locadora.DTOs.FilmeDTO;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Filme;
import com.PA.locadora.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    public List<FilmeDTO> listar() {
        return repository.findAll().stream().map(FilmeDTO::new).collect(Collectors.toList());
    }

    public FilmeDTO buscarPorId(Long id) {
        Filme filme = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Filme não encontrado"));
        return new FilmeDTO(filme);
    }

    public FilmeDTO criar(Filme filme) {
        return new FilmeDTO(repository.save(filme));
    }

    public FilmeDTO atualizar(Long id, Filme novosDados) {
        Filme filme = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Filme não encontrado"));
        filme.setTitulo(novosDados.getTitulo());
        filme.setGenero(novosDados.getGenero());
        filme.setAnoLancamento(novosDados.getAnoLancamento());
        filme.setDisponivel(novosDados.isDisponivel());
        return new FilmeDTO(repository.save(filme));
    }

    public void deletar(Long id) {
        Filme filme = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Filme não encontrado"));
        repository.delete(filme);
    }
}
