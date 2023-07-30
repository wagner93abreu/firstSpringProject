package com.example.demo.domain.usuario;

import com.example.demo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        Papel papel,
        DadosEndereco endereco) {

}
