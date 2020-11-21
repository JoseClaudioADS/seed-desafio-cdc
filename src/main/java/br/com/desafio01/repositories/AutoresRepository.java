package br.com.desafio01.repositories;

import br.com.desafio01.entities.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutoresRepository implements PanacheRepository<Autor> {
}
