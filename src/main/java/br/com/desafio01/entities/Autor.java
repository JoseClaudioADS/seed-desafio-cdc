package br.com.desafio01.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 400)
    private String descricao;

    @Deprecated
    public Autor () {}

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
