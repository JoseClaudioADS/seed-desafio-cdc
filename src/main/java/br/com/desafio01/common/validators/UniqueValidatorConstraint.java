package br.com.desafio01.common.validators;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidatorConstraint implements ConstraintValidator<UniqueValidator, Object> {

    private String propriedade;
    private Class<?> entidade;

    @Override
    public void initialize(UniqueValidator constraintAnnotation) {
        this.propriedade = constraintAnnotation.propriedade();
        this.entidade = constraintAnnotation.entidade();
    }

    @Override
    public boolean isValid(Object valor, ConstraintValidatorContext context) {

        //TODO O quarkus está tendo problema com Bean Sintético (@Inject EntityManager, por exemplo) no contexto da ConstraintValidator
        EntityManager em = CDI.current().select(EntityManager.class).get();

        if (em == null) {
            throw new IllegalArgumentException("EntityManager não pode ser nulo.");
        }

        TypedQuery<Long> query = em.createQuery(
                String.format("SELECT COUNT(e.id) FROM %s e WHERE e.%s = :valor", entidade.getSimpleName(), propriedade),
                Long.class);
        query.setParameter("valor", valor);
        return query.getSingleResult() < 1L;
    }
}
