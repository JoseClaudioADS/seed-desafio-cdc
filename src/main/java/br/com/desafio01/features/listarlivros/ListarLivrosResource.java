package br.com.desafio01.features.listarlivros;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
public class ListarLivrosResource {

    private EntityManager entityManager;

    public ListarLivrosResource (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GET
    public Response listar() {
        return Response.ok(
                entityManager.createQuery("SELECT new " +
                        "br.com.desafio01.features.listarlivros.ListarLivrosResponse(l.isbn, l.titulo) " +
                        "FROM Livro l", ListarLivrosResponse.class).
                        getResultList()).build();
    }
}
