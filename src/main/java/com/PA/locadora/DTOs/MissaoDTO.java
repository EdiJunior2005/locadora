package com.PA.locadora.DTOs;

import java.util.List;

import com.PA.locadora.models.Missao;

public record MissaoDTO(
                Long id,
                String nome,
                String descricao,
                String dificuldade,
                List<Long> ninjasId) {

        public MissaoDTO(Missao missao) {
                this(
                                missao.getId(),
                                missao.getNome(),
                                missao.getDescricao(),
                                missao.getDificuldade(),
                                missao.getNinjas().stream().map(ninja -> ninja.getId()).toList());
        }

}
