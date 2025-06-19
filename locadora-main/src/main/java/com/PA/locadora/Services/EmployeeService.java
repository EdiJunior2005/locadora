package com.PA.locadora.Services;

import com.PA.locadora.DTOs.EmployeeDTO;
import com.PA.locadora.models.Employee;
import com.PA.locadora.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<EmployeeDTO> listar() {
        return repo.findAll().stream().map(EmployeeDTO::new).collect(Collectors.toList());
    }

    public EmployeeDTO salvar(Employee funcionario) {
        return new EmployeeDTO(repo.save(funcionario));
    }
}
