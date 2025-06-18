package com.PA.locadora.Services;

import com.PA.locadora.DTOs.DvdDTO;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Dvd;
import com.PA.locadora.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DvdService {

    @Autowired
    private DvdRepository repository;

    public List<DvdDTO> listar() {
        return repository.findAll().stream()
                .map(DvdDTO::new)
                .collect(Collectors.toList());
    }

    public DvdDTO buscarPorId(Long id) {
        Dvd dvd = repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Dvd não encontrado"));
        return new DvdDTO(dvd);
    }

    public DvdDTO criar(Dvd dvd) {
        return new DvdDTO(repository.save(dvd));
    }

    public DvdDTO atualizar(Long id, Dvd novosDados) {
        Dvd dvd = repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Dvd não encontrado"));

        dvd.setTitle(novosDados.getTitle());
        dvd.setAuthor(novosDados.getAuthor());
        dvd.setDuration(novosDados.getDuration());
        dvd.setClassification(novosDados.getClassification());
        dvd.setCategory(novosDados.getCategory());

        return new DvdDTO(repository.save(dvd));
    }

    public void deletar(Long id) {
        Dvd dvd = repository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Dvd não encontrado"));
        repository.delete(dvd);
    }
}
