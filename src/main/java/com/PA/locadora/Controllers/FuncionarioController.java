package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.FuncionarioDTO;
import com.PA.locadora.Services.FuncionarioService;
import com.PA.locadora.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public FuncionarioDTO salvar(@RequestBody Funcionario funcionario) {
        return service.salvar(funcionario);
    }
}
