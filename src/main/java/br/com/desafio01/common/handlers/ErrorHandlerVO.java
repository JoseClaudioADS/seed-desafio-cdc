package br.com.desafio01.common.handlers;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ErrorHandlerVO {

    private Set<Object> errors = new HashSet<>();
    private LocalDateTime dateTime = LocalDateTime.now();

    @Deprecated
    public ErrorHandlerVO() {}

    public ErrorHandlerVO(Set<Object> errors) {
        this.errors.addAll(errors);
    }

    public Set<Object> getErrors() {
        return errors;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorHandlerVO that = (ErrorHandlerVO) o;
        return Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }
}
