package br.com.desafio01.features.cadastrarcategoria;

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

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarCategoriaResource {

    private Validator validator;

    private EntityManager entityManager;

    public CadastrarCategoriaResource(EntityManager entityManager, Validator validator) {
        this.entityManager = entityManager;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response cadastrar (CadastrarCategoriaFormObject cadastrarCategoriaFormObject) {
        Set<String> mensagens = validator.validate(cadastrarCategoriaFormObject).stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
        if (mensagens.size() > 0) {
            throw new BadRequestException(Arrays.toString(mensagens.toArray()));
        }
        entityManager.persist(cadastrarCategoriaFormObject.toEntity());
        return Response.ok().build();
    }


}
