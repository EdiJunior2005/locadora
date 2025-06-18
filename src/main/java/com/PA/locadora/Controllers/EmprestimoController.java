package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.EmprestimoDTO;
import com.PA.locadora.Services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping
    public List<EmprestimoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public EmprestimoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping("/{clienteId}/{filmeId}")
    public EmprestimoDTO criar(@PathVariable Long clienteId, @PathVariable Long filmeId) {
        return service.criar(clienteId, filmeId);
    }

    @PutMapping("/devolver/{id}")
    public EmprestimoDTO devolver(@PathVariable Long id) {
        return service.devolver(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
