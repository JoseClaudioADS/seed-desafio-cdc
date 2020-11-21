package br.com.desafio01.features.cadastrarcategoria;

import br.com.desafio01.repositories.CategoriasRepository;

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

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarCategoriaResource {

    private Validator validator;

    private CategoriasRepository categoriasRepository;

    public CadastrarCategoriaResource(CategoriasRepository categoriasRepository, Validator validator) {
        this.categoriasRepository = categoriasRepository;
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
        categoriasRepository.persist(cadastrarCategoriaFormObject.toEntity());
        return Response.ok().build();
    }


}
