package com.PA.locadora.Services;

import com.PA.locadora.DTOs.ClienteDTO;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Cliente;
import com.PA.locadora.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteDTO> listar() {
        return repository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado"));
        return new ClienteDTO(cliente);
    }

    public ClienteDTO criar(Cliente cliente) {
        return new ClienteDTO(repository.save(cliente));
    }

    public ClienteDTO atualizar(Long id, Cliente novosDados) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado"));
        cliente.setNome(novosDados.getNome());
        cliente.setCpf(novosDados.getCpf());
        cliente.setTelefone(novosDados.getTelefone());
        cliente.setEmail(novosDados.getEmail());
        return new ClienteDTO(repository.save(cliente));
    }

    public void deletar(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado"));
        repository.delete(cliente);
    }
}
