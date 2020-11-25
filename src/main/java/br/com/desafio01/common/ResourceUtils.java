package br.com.desafio01.common;

import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceUtils {

    /**
     *
     * @param formObject
     * @param validator
     * @return Set<String> contendo os erros.
     */
    public static Set<String> validarFormObject(Object formObject, Validator validator) {
        return validator.validate(formObject).stream().
                map(validationError -> validationError.getPropertyPath() + " - " + validationError.getMessage()).
                collect(Collectors.toSet());
    }
}
