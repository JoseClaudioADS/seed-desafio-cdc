package br.com.desafio01.features.listarlivros;

public class ListarLivrosResponse {

    private String isbn;
    private String titulo;

    public ListarLivrosResponse(String isbn, String titulo) {
        this.isbn = isbn;
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }
}
