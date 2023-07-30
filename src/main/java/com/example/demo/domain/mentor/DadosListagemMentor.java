package com.example.demo.domain.mentor;

public record DadosListagemMentor (Long id, String nome, String email, String telefone, String usuario, Papel papel ){

    public DadosListagemMentor(Mentor mentor) {
        this(mentor.getId(), mentor.getNome(), mentor.getEmail(), mentor.getTelefone(), mentor.getUsuario(), mentor.getPapel());
    }
}
