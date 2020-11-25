package br.com.desafio01.features.cadastrarautor;

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

@Path("/autores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarAutorResource {

    private Validator validator;

    private EntityManager entityManager;

    public CadastrarAutorResource(EntityManager entityManager, Validator validator) {
        this.entityManager = entityManager;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response cadastrar(CadastrarAutorFormObject cadastrarAutorFormObject) {
        Set<String> mensagens = ResourceUtils.validarFormObject(cadastrarAutorFormObject, validator);
        if (mensagens.size() > 0) {
            throw new BadRequestException(Arrays.toString(mensagens.toArray()));
        }
        entityManager.persist(cadastrarAutorFormObject.toEntity());
        return Response.ok().build();
    }


}
