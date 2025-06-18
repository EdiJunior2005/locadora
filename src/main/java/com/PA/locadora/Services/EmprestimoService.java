package com.PA.locadora.Services;

import com.PA.locadora.DTOs.EmprestimoDTO;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Cliente;
import com.PA.locadora.models.Emprestimo;
import com.PA.locadora.models.Filme;
import com.PA.locadora.repositories.ClienteRepository;
import com.PA.locadora.repositories.EmprestimoRepository;
import com.PA.locadora.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private FilmeRepository filmeRepo;

    public List<EmprestimoDTO> listar() {
        return emprestimoRepo.findAll().stream().map(EmprestimoDTO::new).collect(Collectors.toList());
    }

    public EmprestimoDTO buscarPorId(Long id) {
        Emprestimo emp = emprestimoRepo.findById(id).orElseThrow(() -> new NaoEncontradoException("Empréstimo não encontrado"));
        return new EmprestimoDTO(emp);
    }

    public EmprestimoDTO criar(Long clienteId, Long filmeId) {
        Cliente cliente = clienteRepo.findById(clienteId).orElseThrow(() -> new NaoEncontradoException("Cliente não encontrado"));
        Filme filme = filmeRepo.findById(filmeId).orElseThrow(() -> new NaoEncontradoException("Filme não encontrado"));

        if (!filme.isDisponivel()) {
            throw new IllegalStateException("Filme indisponível para empréstimo");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.setFilme(filme);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDevolvido(false);

        filme.setDisponivel(false);
        filmeRepo.save(filme);

        return new EmprestimoDTO(emprestimoRepo.save(emprestimo));
    }

    public EmprestimoDTO devolver(Long id) {
        Emprestimo emp = emprestimoRepo.findById(id).orElseThrow(() -> new NaoEncontradoException("Empréstimo não encontrado"));

        if (emp.isDevolvido()) {
            throw new IllegalStateException("Este empréstimo já foi devolvido");
        }

        emp.setDevolvido(true);
        emp.setDataDevolucao(LocalDate.now());

        Filme filme = emp.getFilme();
        filme.setDisponivel(true);
        filmeRepo.save(filme);

        return new EmprestimoDTO(emprestimoRepo.save(emp));
    }

    public void deletar(Long id) {
        Emprestimo emp = emprestimoRepo.findById(id).orElseThrow(() -> new NaoEncontradoException("Empréstimo não encontrado"));
        emprestimoRepo.delete(emp);
    }
}
