package com.example.demo.domain.usuario;

import com.example.demo.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

        @NotBlank           String nome,
        @NotBlank @Email    String email,
        @NotBlank           String telefone,
        @NotBlank           String usuario,
        @NotNull            Papel papel,
        @NotNull @Valid DadosEndereco endereco ) {

}
