package com.example.demo.domain.mentor;

import com.example.demo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMentor(
        @NotNull Long id,
        String nome,
        String telefone,
        String email,
        Papel papel,
        DadosEndereco endereco) {

}
