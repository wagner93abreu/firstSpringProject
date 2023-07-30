package com.example.demo.domain.mentor;

import com.example.demo.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "mentores")
@Entity(name = "mentor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Mentor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String usuario;
    private Boolean active = false;

    @Enumerated(EnumType.STRING)
    private Papel papel;

    @Embedded
    private Endereco endereco;

    public Mentor(DadosCadastroMentor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.usuario = dados.usuario();
        this.papel = dados.papel();
        this.endereco = new Endereco(dados.endereco());
        this.active = true;

    }

    public void atualizarInformacoes(DadosAtualizacaoMentor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.papel() != null){
            this.papel = dados.papel();
        }
        if( dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void desativar() {
        this.active = false;
    }
}
