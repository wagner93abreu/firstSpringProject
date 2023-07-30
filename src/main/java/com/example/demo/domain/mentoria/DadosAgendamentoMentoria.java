package com.example.demo.domain.mentoria;

import com.example.demo.domain.usuario.Papel;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoMentoria(
        Long idUsuario,
        @NotNull
        Long idMentor,
        @NotNull
        @Future
        LocalDateTime data,
        Papel papel ) {

}
