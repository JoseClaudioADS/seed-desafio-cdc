package br.com.desafio01.features.cadastrarautor;

import br.com.desafio01.common.validators.UniqueValidator;
import br.com.desafio01.entities.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastrarAutorFormObject {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @UniqueValidator(entidade = Autor.class, propriedade = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public Autor toEntity() {
        return new Autor(nome, email.toLowerCase(), descricao);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
