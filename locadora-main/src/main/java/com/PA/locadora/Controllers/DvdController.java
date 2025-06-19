package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.DvdDTO;
import com.PA.locadora.Services.DvdService;
import com.PA.locadora.models.Dvd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dvd")
public class DvdController {

    @Autowired
    private DvdService service;

    @GetMapping
    public List<DvdDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DvdDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public DvdDTO criar(@RequestBody Dvd filme) {
        return service.criar(filme);
    }

    @PutMapping("/{id}")
    public DvdDTO atualizar(@PathVariable Long id, @RequestBody Dvd filme) {
        return service.atualizar(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
