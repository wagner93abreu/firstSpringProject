package com.example.demo.controller;

import com.example.demo.domain.mentoria.DadosAgendamentoMentoria;
import com.example.demo.domain.mentoria.DadosDetalhamentoMentoria;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mentorias")
public class MentoriaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoMentoria dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMentoria(null, null, null, null));
    }
}
