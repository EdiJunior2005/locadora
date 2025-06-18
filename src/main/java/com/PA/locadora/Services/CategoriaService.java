package com.PA.locadora.Services;

import com.PA.locadora.DTOs.CategoriaDTO;
import com.PA.locadora.models.Categoria;
import com.PA.locadora.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public List<CategoriaDTO> listar() {
        return repo.findAll().stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }

    public CategoriaDTO salvar(Categoria categoria) {
        return new CategoriaDTO(repo.save(categoria));
    }
}
