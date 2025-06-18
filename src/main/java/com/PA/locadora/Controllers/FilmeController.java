package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.FilmeDTO;
import com.PA.locadora.Services.FilmeService;
import com.PA.locadora.models.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping
    public List<FilmeDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public FilmeDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public FilmeDTO criar(@RequestBody Filme filme) {
        return service.criar(filme);
    }

    @PutMapping("/{id}")
    public FilmeDTO atualizar(@PathVariable Long id, @RequestBody Filme filme) {
        return service.atualizar(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
