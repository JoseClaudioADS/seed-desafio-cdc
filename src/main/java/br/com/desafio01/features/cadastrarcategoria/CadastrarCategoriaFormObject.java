package br.com.desafio01.features.cadastrarcategoria;

import br.com.desafio01.common.validators.UniqueValidator;
import br.com.desafio01.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class CadastrarCategoriaFormObject {

    @NotBlank
    @UniqueValidator(entidade = Categoria.class, propriedade = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toEntity() {
        return new Categoria(this.nome);
    }
}
