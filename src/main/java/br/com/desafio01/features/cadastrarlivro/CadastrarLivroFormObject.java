package br.com.desafio01.features.cadastrarlivro;

import br.com.desafio01.common.validators.UniqueValidator;
import br.com.desafio01.entities.Autor;
import br.com.desafio01.entities.Categoria;
import br.com.desafio01.entities.Livro;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import javax.ws.rs.BadRequestException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class CadastrarLivroFormObject {

    @NotBlank
    @UniqueValidator(entidade = Livro.class, propriedade = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int numeroPaginas;

    @NotBlank
    @UniqueValidator(entidade = Livro.class, propriedade = "isbn")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long autorId;

    public Livro toEntity(EntityManager entityManager) {

        Autor autor = Optional.ofNullable(entityManager.find(Autor.class, autorId)).
                orElseThrow(() -> new BadRequestException("Autor não encontrado."));
        Categoria categoria = Optional.ofNullable(entityManager.find(Categoria.class, categoriaId)).
                orElseThrow(() -> new BadRequestException("Categoria não encontrada."));
        Livro livro = new Livro(titulo, resumo, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
        livro.setSumario(sumario);
        return livro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

}
