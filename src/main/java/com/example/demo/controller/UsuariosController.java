package com.example.demo.controller;

import com.example.demo.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public Page<DadosListagemUsuario> listar(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAllByActiveTrue(paginacao).map(DadosListagemUsuario::new);
        //o metodo padrao para a chamada é findAll
        //como queria retirar os usuarios inativo bastou colocar o By + Active(atributo) + True (valor)
        //o JPA ja reconhece como parametros da query de paginacao
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
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
    public void desativar(@PathVariable Long id){
        var usuario = repository.getReferenceById(id);
        usuario.desativar();
    }

}
