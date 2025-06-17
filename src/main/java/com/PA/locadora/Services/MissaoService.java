package com.PA.locadora.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PA.locadora.DTOs.MissaoDTO;
import com.PA.locadora.Exceptions.DeleteNegadoException;
import com.PA.locadora.Exceptions.NaoEncontradoException;
import com.PA.locadora.models.Missao;
import com.PA.locadora.models.Ninja;
import com.PA.locadora.repositories.MissaoRepository;
import com.PA.locadora.repositories.NinjaRepository;

import jakarta.transaction.Transactional;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final NinjaRepository ninjaRepository;

    public MissaoService(MissaoRepository missaoRepository, NinjaRepository ninjaRepository) {
        this.missaoRepository = missaoRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public MissaoDTO salvar(MissaoDTO missao) {

        Missao missaoEntity = new Missao(missao);

        List<Ninja> ninjas = ninjaRepository.findAllById(missao.ninjasId()).stream()
                .map(ninja -> {
                    ninja.setMissao(missaoEntity);
                    return ninja;
                }).toList();

        missaoEntity.setNinjas(ninjas);

        return new MissaoDTO(missaoRepository.save(missaoEntity));
    }

    public MissaoDTO salvar(Long id, MissaoDTO missao) {
        missaoRepository.findById(id).orElseThrow(() -> new NaoEncontradoException("Missao não encontrada!"));
        Missao missaoEntity = new Missao(missao);
        missaoEntity.setId(id);

        List<Ninja> ninjas = ninjaRepository.findAllById(missao.ninjasId()).stream()
                .map(ninja -> {
                    ninja.setMissao(missaoEntity);
                    return ninja;
                }).toList();

        missaoEntity.setNinjas(ninjas);

        return new MissaoDTO(missaoRepository.save(missaoEntity));
    }

    public List<MissaoDTO> listar() {
        return missaoRepository.findAll().stream().map(missao -> new MissaoDTO(missao)).toList();
    }

    @Transactional
    public void remover(Long id) throws Exception {
        Missao missao = missaoRepository
                .findById(id)
                .orElseThrow(
                        () -> new NaoEncontradoException("Missão com id " + id + "não encontrada."));

        if (missao != null) {
            missao.getNinjas().forEach(ninja -> {
                ninja.setMissao(null);
                ninjaRepository.save(ninja);
            });
        }
        missaoRepository.deleteById(id);
    }

    public MissaoDTO buscarPorId(Long id) throws NaoEncontradoException {
        return new MissaoDTO(missaoRepository.findById(id)
                .orElseThrow(() -> new NaoEncontradoException("Missão com id " + id + "não encontrada.")));
    }
}
