package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.CustomerDTO;
import com.PA.locadora.Services.CustomerService;
import com.PA.locadora.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CustomerDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public CustomerDTO criar(@RequestBody Customer cliente) {
        return service.criar(cliente);
    }

    @PutMapping("/{id}")
    public CustomerDTO atualizar(@PathVariable Long id, @RequestBody Customer cliente) {
        return service.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
