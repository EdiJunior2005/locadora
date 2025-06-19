package com.PA.locadora.Services;

import com.PA.locadora.DTOs.CustomerDTO;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Customer;
import com.PA.locadora.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public List<CustomerDTO> listar() {
        return repository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    public CustomerDTO buscarPorId(Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Customer não encontrado"));
        return new CustomerDTO(customer);
    }

    public CustomerDTO criar(Customer customer) {
        return new CustomerDTO(repository.save(customer));
    }

    public CustomerDTO atualizar(Long id, Customer novosDados) {
        Customer customer = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Customer não encontrado"));
        customer.setName(novosDados.getName());
        customer.setDocument(novosDados.getDocument());
        customer.setPhone(novosDados.getPhone());
        return new CustomerDTO(repository.save(customer));
    }

    public void deletar(Long id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Customer não encontrado"));
        repository.delete(customer);
    }
}
