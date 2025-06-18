package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.CategoriaDTO;
import com.PA.locadora.Services.CategoriaService;
import com.PA.locadora.models.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<CategoriaDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public CategoriaDTO salvar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }
}
