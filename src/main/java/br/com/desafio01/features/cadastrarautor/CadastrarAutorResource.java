package br.com.desafio01.features.cadastrarautor;

import br.com.desafio01.repositories.AutoresRepository;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
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

    private AutoresRepository autoresRepository;

    public CadastrarAutorResource(AutoresRepository autoresRepository, Validator validator) {
        this.autoresRepository = autoresRepository;
        this.validator = validator;
    }

    @POST
    @Transactional
    public Response cadastrar(CadastrarAutorFormObject cadastrarAutorFormObject) {
        Set<String> mensagens = validator.validate(cadastrarAutorFormObject).stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
        if (mensagens.size() > 0) {
            throw new BadRequestException(Arrays.toString(mensagens.toArray()));
        }
        autoresRepository.persist(cadastrarAutorFormObject.toEntity());
        return Response.ok().build();
    }
}
