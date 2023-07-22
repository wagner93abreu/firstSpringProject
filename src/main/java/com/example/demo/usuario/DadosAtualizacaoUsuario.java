package com.example.demo.usuario;

import com.example.demo.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUsuario(
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        Papel papel,
        DadosEndereco endereco) {

}
