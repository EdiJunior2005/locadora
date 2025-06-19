package com.PA.locadora.Services;

import com.PA.locadora.DTOs.RentalDTO;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Customer;
import com.PA.locadora.models.Rental;
import com.PA.locadora.models.Dvd;
import com.PA.locadora.repositories.CustomerRepository;
import com.PA.locadora.repositories.RentalRepository;
import com.PA.locadora.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    @Autowired
    private RentalRepository emprestimoRepo;

    @Autowired
    private CustomerRepository clienteRepo;

    @Autowired
    private DvdRepository filmeRepo;

    public List<RentalDTO> listar() {
        return emprestimoRepo.findAll().stream().map(RentalDTO::new).collect(Collectors.toList());
    }

    public RentalDTO buscarPorId(Long id) {
        Rental emp = emprestimoRepo.findById(id).orElseThrow(() -> new NaoEncontradoException("Empréstimo não encontrado"));
        return new RentalDTO(emp);
    }

    public RentalDTO criar(Long clienteId, Long filmeId) {
        Customer cliente = clienteRepo.findById(clienteId).orElseThrow(() -> new NaoEncontradoException("Customer não encontrado"));
        Dvd filme = filmeRepo.findById(filmeId).orElseThrow(() -> new NaoEncontradoException("Dvd não encontrado"));

        if (!filme.isDisponivel()) {
            throw new IllegalStateException("Dvd indisponível para empréstimo");
        }

        Rental emprestimo = new Rental();
        emprestimo.setCustomer(cliente);
        emprestimo.setDvd(filme);
        emprestimo.setRentalDate(LocalDateTime.now());
        emprestimo.setReturnDate(null);                 

        filme.setDisponivel(false);
        filmeRepo.save(filme);

        return new RentalDTO(emprestimoRepo.save(emprestimo));
    }


    public RentalDTO devolver(Long id) {
        Rental emp = emprestimoRepo.findById(id).orElseThrow(() -> new NaoEncontradoException("Empréstimo não encontrado"));

        if (emp.getReturnDate() != null) { 
            throw new IllegalStateException("Este empréstimo já foi devolvido");
        }

        emp.setReturnDate(LocalDateTime.now());

        Dvd filme = emp.getDvd();
        filme.setDisponivel(true);
        filmeRepo.save(filme);

        return new RentalDTO(emprestimoRepo.save(emp));
    }

    public void deletar(Long id) {
        Rental emp = emprestimoRepo.findById(id).orElseThrow(() -> new NaoEncontradoException("Empréstimo não encontrado"));
        emprestimoRepo.delete(emp);
    }
}
