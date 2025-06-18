package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.EmployeeDTO;
import com.PA.locadora.Services.EmployeeService;
import com.PA.locadora.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public EmployeeDTO salvar(@RequestBody Employee funcionario) {
        return service.salvar(funcionario);
    }
}
