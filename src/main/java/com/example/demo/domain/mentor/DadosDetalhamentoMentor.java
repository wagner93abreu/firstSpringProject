package com.example.demo.domain.mentor;

import com.example.demo.domain.endereco.Endereco;

public record DadosDetalhamentoMentor(Long id, String nome, String email, String telefone, String usuario, Papel papel,
                                      Endereco endereco, Boolean active) {

    public DadosDetalhamentoMentor(Mentor mentor){
        this(mentor.getId(), mentor.getNome(), mentor.getEmail(), mentor.getTelefone(), mentor.getUsuario(), mentor.getPapel(), mentor.getEndereco(), mentor.getActive());
    }
}
