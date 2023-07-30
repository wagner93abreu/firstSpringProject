package com.example.demo.controller;

import com.example.demo.domain.mentor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("mentores")
public class MentoresController {

    @Autowired
    private MentorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMentor dados, UriComponentsBuilder uriBuilder){
        var mentor = new Mentor(dados);

        repository.save(mentor);

        var uri = uriBuilder.path("/mentores/{id}").buildAndExpand(mentor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMentor(mentor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMentor>> listar(@PageableDefault(size = 10) Pageable paginacao){
        var page = repository.findAllByActiveTrue(paginacao).map(DadosListagemMentor::new);
        //o metodo padrao para a chamada é findAll
        //como queria retirar os usuarios inativo bastou colocar o By + Active(atributo) + True (valor)
        //o JPA ja reconhece como parametros da query de paginacao

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMentor dados){
        var mentor = repository.getReferenceById(dados.id());
        mentor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMentor(mentor));
    }

    //exclusao fisica do bd
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

    //exclusao logica
    @DeleteMapping("desativar/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.desativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var mentor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMentor(mentor));
    }



}
