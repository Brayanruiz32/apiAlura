package med.voll.api.infra;

import java.util.NoSuchElementException;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.ResponseEntity;
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

        return ResponseEntity.badRequest().body(e.getFieldErrors().stream().map(err -> err.getField()+ ": "+err.getDefaultMessage()).toList());

    }

}
