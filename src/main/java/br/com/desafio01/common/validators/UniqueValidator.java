package br.com.desafio01.common.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueValidatorConstraint.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValidator {

    String message() default
            "Já existe um registro em '${entidade.getSimpleName()} - {propriedade}' com o valor: ${validatedValue}.";

    //String message() default "Já existe um registro com a propriedade '{propriedade}' utilizando o valor '${validatedValue}'"

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> entidade();

    String propriedade();
}
