package com.PA.locadora.Services;

import com.PA.locadora.DTOs.FuncionarioDTO;
import com.PA.locadora.models.Funcionario;
import com.PA.locadora.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    public List<FuncionarioDTO> listar() {
        return repo.findAll().stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

    public FuncionarioDTO salvar(Funcionario funcionario) {
        return new FuncionarioDTO(repo.save(funcionario));
    }
}
