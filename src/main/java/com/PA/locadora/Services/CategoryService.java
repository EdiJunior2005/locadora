package com.PA.locadora.Services;

import com.PA.locadora.DTOs.CategoryDTO;
import com.PA.locadora.models.Category;
import com.PA.locadora.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<CategoryDTO> listar() {
        return repo.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    public CategoryDTO salvar(Category category) {
        return new CategoryDTO(repo.save(category));
    }
}
