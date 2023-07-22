package com.example.demo.usuario;

public record DadosListagemUsuario(Long id, String nome, String email, String telefone, String usuario, Papel papel ) {

    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getUsuario(), usuario.getPapel());
    }

}
