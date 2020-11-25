package br.com.desafio01.features.cadastrarlivro;

import br.com.desafio01.common.ResourceUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarLivroResource {

    private Validator validator;

    private EntityManager entityManager;

    public CadastrarLivroResource(Validator validator, EntityManager entityManager) {
        this.validator = validator;
        this.entityManager = entityManager;
    }

    @POST
    @Transactional
    public Response cadastrar(CadastrarLivroFormObject cadastrarLivroFormObject) {
        Set<String> mensagens = ResourceUtils.validarFormObject(cadastrarLivroFormObject, validator);
        if (mensagens.size() > 0) {
            throw new BadRequestException(Arrays.toString(mensagens.toArray()));
        }
        entityManager.persist(cadastrarLivroFormObject.toEntity(entityManager));
        return Response.ok().build();
    }
}
