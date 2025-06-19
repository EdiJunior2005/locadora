package com.PA.locadora.Controllers;

import com.PA.locadora.DTOs.CategoryDTO;
import com.PA.locadora.Services.CategoryService;
import com.PA.locadora.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<CategoryDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public CategoryDTO salvar(@RequestBody Category categoria) {
        return service.salvar(categoria);
    }
}
