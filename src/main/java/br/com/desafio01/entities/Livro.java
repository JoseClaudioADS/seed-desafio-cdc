package br.com.desafio01.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @NotBlank
    private String isbn;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Size(max = 500)
    @Column(nullable = false, unique = true)
    private String resumo;

    private String sumario;

    @Min(20)
    @Column(nullable = false, unique = true)
    private BigDecimal preco;

    @Min(100)
    @Column(nullable = false, unique = true)
    private int numeroPaginas;

    @Future
    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne(optional = false)
    private Categoria categoria;

    @ManyToOne(optional = false)
    private Autor autor;

    @Deprecated
    public Livro() {

    }

    public Livro(String titulo, String resumo, BigDecimal preco, int numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }
}
