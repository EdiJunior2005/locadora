package com.PA.locadora.DTOs;

import com.PA.locadora.models.Ninja;

public record NinjaDTO(
        Long id,
        String nome,
        int idade,
        String cla,
        String vila,    
        Long missaoId) {

    public NinjaDTO(Ninja ninja) {
        this(
                ninja.getId(),
                ninja.getNome(),
                ninja.getIdade(),
                ninja.getCla(),
                ninja.getVila() != null ? ninja.getVila().getNome() : null, 
                ninja.getMissao() != null ? ninja.getMissao().getId() : null);
    }
}
