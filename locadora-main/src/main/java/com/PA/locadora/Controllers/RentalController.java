package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.RentalDTO;
import com.PA.locadora.Services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class RentalController {

    @Autowired
    private RentalService service;

    @GetMapping
    public List<RentalDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public RentalDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/{clienteId}/{filmeId}")
    public RentalDTO criar(@PathVariable Long clienteId, @PathVariable Long filmeId) {
        return service.criar(clienteId, filmeId);
    }

    @PutMapping("/devolver/{id}")
    public RentalDTO devolver(@PathVariable Long id) {
        return service.devolver(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
