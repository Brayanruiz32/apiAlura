package med.voll.api.infra.errores;

import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        List<DataErrorMensaje> errores = e.getFieldErrors().stream().map(DataErrorMensaje::new).toList();
        return ResponseEntity.badRequest().body(errores);

    }

    public record DataErrorMensaje(
            String field,

            String mensaje) {
        public DataErrorMensaje(FieldError err) {
            this(err.getField(), err.getDefaultMessage());

        }
    }

}
