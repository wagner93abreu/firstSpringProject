package com.example.demo.domain.usuario;

import com.example.demo.domain.endereco.Endereco;

public record DadosDetalhamentoUsuario (Long id, String nome, String email, String usuario, String telefone, Papel papel, Endereco endereco){

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getUsuario(), usuario.getEmail(), usuario.getNome(), usuario.getTelefone(), usuario.getPapel(), usuario.getEndereco());

    }

}
