package med.voll.api.infra;

import org.springframework.validation.FieldError;

public record DataErrorMensaje(
    String field, 

    String mensaje
) {
    public DataErrorMensaje(FieldError err){
        this(err.getField(), err.getDefaultMessage());

    }
}
