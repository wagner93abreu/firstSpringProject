package com.example.demo.domain.mentoria;

import java.time.LocalDateTime;

public record DadosDetalhamentoMentoria(Long id, Long  idUsuario, Long idMentor, LocalDateTime data) {
}
