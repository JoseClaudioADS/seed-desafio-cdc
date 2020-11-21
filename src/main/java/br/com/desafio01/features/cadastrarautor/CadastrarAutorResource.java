package br.com.desafio01.features.cadastrarautor;

import br.com.desafio01.repositories.AutoresRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/autores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrarAutorResource {

    @Inject
    AutoresRepository autoresRepository;

    public CadastrarAutorResource(AutoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    @POST
    @Transactional
    public Response cadastrar(@Valid CadastrarAutorFormObject cadastrarAutorFormObject) {
        autoresRepository.persist(cadastrarAutorFormObject.toEntity());
        return Response.ok().build();
    }
}
